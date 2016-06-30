package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import models.Ingredient;
import models.Recipe;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class RecipesCtrl extends Controller {

	@Inject
	private FormFactory formFactory;

	public Result createRecipe() {
		return ok(views.html.recipesForm.render("Create", formFactory.form(Recipe.class), Ingredient.read()));
	}

	public Result readRecipes() {
		return ok(views.html.recipes.render(Recipe.read()));
	}

	public Result updateRecipe(Long iid) {
		Recipe recipe = Recipe.find.byId(iid);
		Form<Recipe> filledForm = formFactory.form(Recipe.class).fill(recipe);
		return ok(views.html.recipesForm.render("Update", filledForm, Ingredient.read()));
	}

	public Result deleteRecipe(Long rid) {
		Recipe.delete(rid);
		return redirect(routes.RecipesCtrl.readRecipes());
	}

	public Result storeRecipe() {
		Form<Recipe> recipeForm = formFactory.form(Recipe.class);
		Form<Recipe> filledForm = recipeForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return ok(views.html.recipesForm.render("Correct", filledForm, Ingredient.read()));
		} else {
			Recipe recipe = filledForm.get();
			List<Long> selectedIngredients = this.getMultiSelectIDs(filledForm.data(), "ingredients.iid");
			for (Long ingredientID : selectedIngredients) {
				Ingredient tmpIngredient = Ingredient.find.byId(ingredientID);
				recipe.ingredients.add(tmpIngredient);
			}
			if (recipe.rid == null)
				Recipe.create(recipe);
			else
				Recipe.update(recipe);
			return ok(views.html.recipes.render(Recipe.read()));
		}
	}

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
