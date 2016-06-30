package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Ingredient extends Model {
	@Id
	public Long iid;
	@Required
	public String name;
	public String description;
	@ManyToMany(mappedBy = "ingredients")
	public List<Recipe> recipes;

	public static Finder<Long, Ingredient> find = new Finder<Long, Ingredient>(Ingredient.class);

	public static void create(Ingredient ingredient) {
		ingredient.save();
	}

	public static List<Ingredient> read() {
		return find.all();
	}

	public static void update(Ingredient updatedIngredient) {
		updatedIngredient.update();
	}

	public static void delete(Long iid) {
		find.ref(iid).delete();
	}

	public static Map<Long, String> getAllAsMap() {
		HashMap<Long, String> ingredientsMap = new HashMap<Long, String>();
		List<Ingredient> ingredients = Ingredient.read();
		for (Ingredient ingredient : ingredients) {
			ingredientsMap.put(ingredient.iid, ingredient.name);
		}
		return ingredientsMap;
	}
}