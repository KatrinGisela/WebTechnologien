package controllers;

import javax.inject.Inject;

import models.Partie;
import models.Stadion;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class PartiesCtrl extends Controller {

	@Inject
	private FormFactory formFactory;

	/**
	 * Creates a new partie under the condition that the partie is not
	 * registered yet in the stadium.
	 * 
	 */
	public Result createPartie() {
		if (!Stadion.find.all().isEmpty()) {
			return ok(views.html.partiesForm.render("Create",
					formFactory.form(Partie.class), Stadion.find.all()));
		}
		return ok(views.html.stadienForm.render("Create",
				formFactory.form(Stadion.class), Partie.read()));
	}

	/**
	 * Reads and displays the certain partie(s)
	 */
	public Result readParties() {
		return ok(views.html.parties.render(Partie.read()));
	}

	/**
	 * Updates the partie information with the user inputs
	 * 
	 * @param pid
	 *            the partie id of the partie that is to be updated
	 */
	public Result updatePartie(Long pid) {
		Partie partie = Partie.find.byId(pid);
		Form<Partie> filledForm = formFactory.form(Partie.class).fill(partie);
		return ok(views.html.partiesForm.render("Update", filledForm,
				Stadion.find.all()));
	}

	/**
	 * Deletes the chosen partie if it existst in the database
	 * 
	 * @param pid
	 *            the partie id of the partie that is to be deleted
	 */
	public Result deletePartie(Long pid) {
		Partie.delete(pid);
		return redirect(routes.PartiesCtrl.readParties());
	}

	/**
	 * Stores the information about a partie. If the partie already existed, the
	 * method updates the new information, otherwise a new party will be created
	 * and stored.
	 */
	public Result storePartie() {
		Form<Partie> partieForm = formFactory.form(Partie.class);
		Form<Partie> filledForm = partieForm.bindFromRequest();
		if (isFormDateEqualToStadionPartieDate(filledForm)
				|| filledForm.hasErrors()) {
			return ok(views.html.partiesForm.render("Correct", filledForm,
					Stadion.find.all()));
		} else {
			Partie partie = filledForm.get();
			if (partie.pid == null) {
				Partie.create(partie);
			} else {
				Partie.update(partie);
			}
			return redirect(routes.PartiesCtrl.readParties());
		}
	}

	public boolean isFormDateEqualToStadionPartieDate(Form<Partie> inputForm) {
		System.out.println("metodo");
		for (Partie partie : inputForm.get().stadion.parties) {
			System.out.println("for");
			if ((inputForm.get().partieDatum).equals(partie.partieDatum)) {
				System.out.println("if");
				return true;
			}
		}

		return false;
	}
}