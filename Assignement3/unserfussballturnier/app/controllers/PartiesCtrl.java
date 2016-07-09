package controllers;

import javax.inject.Inject;

import models.Partie;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class PartiesCtrl extends Controller {
	
	@Inject
	private FormFactory formFactory;
	
	public Result createPartie() {
		return ok(views.html.partiesForm.render("Create", formFactory.form(Partie.class)));
	}

	public Result readParties() {
		return ok(views.html.parties.render(Partie.read()));
	}

	public Result updateParte(Long pid) {
		Partie partie  = Partie.find.byId(pid);
		Form<Partie> filledForm = formFactory.form(Partie.class).fill(partie);
		return ok(views.html.partiesForm.render("Update", filledForm));
	}

	public Result deleteParttie(Long pid) {
		Partie.delete(pid);
		return redirect(routes.PartiesCtrl.readParties());
	}

	public Result storePartie() {
		Form<Partie> partieForm = formFactory.form(Partie.class);
		Form<Partie> filledForm = partieForm.bindFromRequest();
		if (filledForm.hasErrors()){
			return ok(views.html.partieForm.render("Correct", filledForm));
		}
		else {
			Partie partie = filledForm.get();
			if (partie.pid == null){
				Partie.create(partie);
			} else {
				Partie.update(partie);
			}
			return redirect(routes.PartiesCtrl.readParties());
		}
	}
}