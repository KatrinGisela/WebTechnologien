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

	public Result createPartie() {
		if (!Stadion.find.all().isEmpty()) {
			return ok(views.html.partiesForm.render("Create",
					formFactory.form(Partie.class), Stadion.find.all()));
		}
		return ok("Noch keine Stadien vorhanden. Bitte ein Stadion hinzufügen");
	}

	public Result readParties() {
		return ok(views.html.parties.render(Partie.read()));
	}

	public Result updatePartie(Long pid) {
		Partie partie = Partie.find.byId(pid);
		Form<Partie> filledForm = formFactory.form(Partie.class).fill(partie);
		return ok(views.html.partiesForm.render("Update", filledForm,
				Stadion.find.all()));
	}

	public Result deletePartie(Long pid) {
		Partie.delete(pid);
		return redirect(routes.PartiesCtrl.readParties());
	}

	public Result storePartie() {
		Form<Partie> partieForm = formFactory.form(Partie.class);
		Form<Partie> filledForm = partieForm.bindFromRequest();
		if (filledForm.hasErrors()) {
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
}