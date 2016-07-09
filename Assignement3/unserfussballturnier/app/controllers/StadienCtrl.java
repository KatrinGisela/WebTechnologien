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

	public Result createStadion() {
		return ok(views.html.stadienForm.render("Create",
				formFactory.form(Stadion.class), Partie.read()));
	}

	public Result readStadien() {
		return ok(views.html.stadien.render(Stadion.read()));
	}

	public Result updateStadion(Long pid) {
		Stadion stadion = Stadion.find.byId(pid);
		Form<Stadion> filledForm = formFactory.form(Stadion.class)
				.fill(stadion);
		return ok(views.html.stadienForm.render("Update", filledForm,
				Partie.read()));
	}

	public Result deleteStadion(Long sid) {
		Stadion.delete(sid);
		return redirect(routes.StadienCtrl.readStadien());
	}

	public Result storeStadion() {
		Form<Stadion> stadionForm = formFactory.form(Stadion.class);
		Form<Stadion> filledForm = stadionForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.stadienForm.render("Correct", filledForm,
					Partie.read()));
		} else {
			Stadion stadion = filledForm.get();
			List<Long> selectedPartien = this.getMultiSelectIDs(
					filledForm.data(), "partien.pid");
			for (Long partieID : selectedPartien) {
				Partie tmpPartie = Partie.find.byId(partieID);
				stadion.parties.add(tmpPartie);
			}
			if (stadion.sid == null)
				Stadion.create(stadion);
			else
				Stadion.update(stadion);
			return ok(views.html.stadien.render(Stadion.read()));
		}
	}

	public List<Long> getMultiSelectIDs(Map<String, String> formMap,
			String multiName) {
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
