package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Recipe extends Model {
	@Id
	public Long rid;
	@Required
	public String name;
	public String description;
	@ManyToMany(cascade = CascadeType.REMOVE)
	public List<Ingredient> ingredients;
	public static Finder<Long, Recipe> find = new Finder<Long,Recipe>(Recipe.class);

	public static void create(Recipe ingredient) {
		ingredient.save();
	}

	public static List<Recipe> read() {
		return find.all();
	}

	public static void update(Recipe updatedIngredient) {
		updatedIngredient.update();
	}

	public static void delete(Long rid) {
		find.ref(rid).delete();
	}
}
