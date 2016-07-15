package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import models.Partie;
import models.Stadion;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class StadienCtrl extends Controller {

	@Inject
	private FormFactory formFactory;

	/**
	 * Creates a new stadium under the condition that the stadium is not
	 * registered yet.
	 */
	public Result createStadion() {
		return ok(views.html.stadienForm.render("Create", formFactory.form(Stadion.class), Partie.read()));
	}

	/**
	 * Reads and displays the stadium
	 */
	public Result readStadien() {
		return ok(views.html.stadien.render(Stadion.read()));
	}

	/**
	 * Updates the stadium information with the user inputs
	 * 
	 * @param pid
	 *            the partie id of the partie that is to be updated
	 */
	public Result updateStadion(Long pid) {
		Stadion stadion = Stadion.find.byId(pid);
		Form<Stadion> filledForm = formFactory.form(Stadion.class).fill(stadion);
		return ok(views.html.stadienForm.render("Update", filledForm, Partie.read()));
	}

	/**
	 * Deletes the chosen stadium
	 * 
	 * @param sid
	 *            the stadium id of the stadium that is to be deleted
	 */
	public Result deleteStadion(Long sid) {
		Stadion.delete(sid);
		return redirect(routes.StadienCtrl.readStadien());
	}

	/**
	 * Stores the information about a stadium. If the stadium didn't exist yet,
	 * a new stadium will be created, otherwise the parties information within
	 * the certain stadium will be updated.
	 */
	public Result storeStadion() {
		Form<Stadion> stadionForm = formFactory.form(Stadion.class);
		Form<Stadion> filledForm = stadionForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.stadienForm.render("Correct", filledForm, Partie.read()));
		} else {
			Stadion stadion = filledForm.get();
			List<Long> selectedPartien = this.getMultiSelectIDs(filledForm.data(), "partien.pid");
			for (Long partieID : selectedPartien) {
				Partie tmpPartie = Partie.find.byId(partieID);
				stadion.parties.add(tmpPartie);
			}
			if (stadion.sid == null) {
				Stadion.create(stadion);
			} else {
				Stadion.update(stadion);
			}
			return redirect(routes.StadienCtrl.readStadien());
		}
	}

	/**
	 * 
	 * Adds the parties to the stadium they take place.
	 *  
	 *@param formMap 
	 *@param multiName
	 *@return the selected partie ids of the certain stadium.
	 */
	public List<Long> getMultiSelectIDs(Map<String, String> formMap, String multiName) {
		ArrayList<Long> selectedIDs = new ArrayList<Long>();
		Set<String> fieldNames = formMap.keySet();
		for (String fieldName : fieldNames) {
			if (fieldName.toLowerCase().contains(multiName.toLowerCase())) {
				Long tmpID = Long.parseLong(formMap.get(fieldName));
				selectedIDs.add(tmpID);
			}
		}
		return selectedIDs;
	}
}
