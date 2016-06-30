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
		return ok(views.html.ingredientsForm.render("Create", formFactory.form(Partie.class)));
	}

	public Result readIngredients() {
		return ok(views.html.ingredients.render(Partie.read()));
	}

	public Result updateIngredient(Long iid) {
		Partie ingredient  = Partie.find.byId(iid);
		Form<Partie> filledForm = formFactory.form(Partie.class).fill(ingredient);
		return ok(views.html.ingredientsForm.render("Update", filledForm));
	}

	public Result deleteIngredient(Long iid) {
		Partie.delete(iid);
		return redirect(routes.PartienCtrl.readIngredients());
	}

	public Result storeIngredient() {
		Form<Partie> ingredientForm = formFactory.form(Partie.class);
		Form<Partie> filledForm = ingredientForm.bindFromRequest();
		if (filledForm.hasErrors()){
			return ok(views.html.ingredientsForm.render("Correct", filledForm));
		}
		else {
			Partie ingredient = filledForm.get();
			if (ingredient.pid == null){
				Partie.create(ingredient);
			} else {
				Partie.update(ingredient);
			}
			return redirect(routes.PartienCtrl.readIngredients());
		}
	}
}