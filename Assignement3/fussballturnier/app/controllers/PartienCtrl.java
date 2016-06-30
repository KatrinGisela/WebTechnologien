package controllers;

import javax.inject.Inject;

import models.Ingredient;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class PartienCtrl extends Controller {
	
	@Inject
	private FormFactory formFactory;
	
	public Result createIngredient() {
		return ok(views.html.ingredientsForm.render("Create", formFactory.form(Ingredient.class)));
	}

	public Result readIngredients() {
		return ok(views.html.ingredients.render(Ingredient.read()));
	}

	public Result updateIngredient(Long iid) {
		Ingredient ingredient  = Ingredient.find.byId(iid);
		Form<Ingredient> filledForm = formFactory.form(Ingredient.class).fill(ingredient);
		return ok(views.html.ingredientsForm.render("Update", filledForm));
	}

	public Result deleteIngredient(Long iid) {
		Ingredient.delete(iid);
		return redirect(routes.PartienCtrl.readIngredients());
	}

	public Result storeIngredient() {
		Form<Ingredient> ingredientForm = formFactory.form(Ingredient.class);
		Form<Ingredient> filledForm = ingredientForm.bindFromRequest();
		if (filledForm.hasErrors()){
			return ok(views.html.ingredientsForm.render("Correct", filledForm));
		}
		else {
			Ingredient ingredient = filledForm.get();
			if (ingredient.iid == null){
				Ingredient.create(ingredient);
			} else {
				Ingredient.update(ingredient);
			}
			return redirect(routes.PartienCtrl.readIngredients());
		}
	}
}