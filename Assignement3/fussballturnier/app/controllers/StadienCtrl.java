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

	// TODO
	public Result createStadion() {
		return ok(views.html.recipesForm.render("Create",
				formFactory.form(Stadion.class), Partie.read()));
	}

	// TODO
	public Result readStadion() {
		return ok(views.html.recipes.render(Stadion.read()));
	}

	// TODO
	public Result updateStadion(Long iid) {
		Stadion recipe = Stadion.find.byId(iid);
		Form<Stadion> filledForm = formFactory.form(Stadion.class).fill(recipe);
		return ok(views.html.recipesForm.render("Update", filledForm,
				Partie.read()));
	}

	// TODO
	public Result deleteStadion(Long sid) {
		Stadion.delete(sid);
		return redirect(routes.StadienCtrl.readStadion());
	}

	// TODO
	public Result storeStadion() {
		Form<Stadion> recipeForm = formFactory.form(Stadion.class);
		Form<Stadion> filledForm = recipeForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.recipesForm.render("Correct", filledForm,
					Partie.read()));
		} else {
			Stadion recipe = filledForm.get();
			List<Long> selectedIngredients = this.getMultiSelectIDs(
					filledForm.data(), "ingredients.iid");
			for (Long ingredientID : selectedIngredients) {
				Partie tmpIngredient = Partie.find.byId(ingredientID);
				recipe.ingredients.add(tmpIngredient);
			}
			if (recipe.sid == null)
				Stadion.create(recipe);
			else
				Stadion.update(recipe);
			return ok(views.html.recipes.render(Stadion.read()));
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
