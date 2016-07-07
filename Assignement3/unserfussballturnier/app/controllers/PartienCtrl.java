package controllers;

import javax.inject.Inject;

import models.Partie;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class PartienCtrl extends Controller {

	@Inject
	private FormFactory formFactory;

	public Result createIngredient() {
		return ok(views.html.partienForm.render("Create",
				formFactory.form(Partie.class)));
	}

	public Result readPartien() {
		return ok(views.html.partien.render(Partie.read()));
	}

	public Result updatePartie(Long iid) {
		Partie ingredient = Partie.find.byId(iid);
		Form<Partie> filledForm = formFactory.form(Partie.class).fill(
				ingredient);
		return ok(views.html.partienForm.render("Update", filledForm));
	}

	public Result deletePartie(Long iid) {
		Partie.delete(iid);
		return redirect(routes.PartienCtrl.readPartien());
	}

	public Result storePartie() {
		Form<Partie> partieForm = formFactory.form(Partie.class);
		Form<Partie> filledForm = partieForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.partienForm.render("Correct", filledForm));
		} else {
			Partie partie = filledForm.get();
			if (partie.pid == null) {
				Partie.create(partie);
			} else {
				Partie.update(partie);
			}
			return redirect(routes.PartienCtrl.readPartien());
		}
	}
}