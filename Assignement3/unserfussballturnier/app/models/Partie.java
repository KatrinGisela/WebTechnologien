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
public class Partie extends Model {
	@Id
	public Long pid;
	@Required
	public String name;
	public String description;
	@ManyToMany(mappedBy = "ingredients")
	public List<Stadion> recipes;

	public static Finder<Long, Partie> find = new Finder<Long, Partie>(Partie.class);

	public static void create(Partie ingredient) {
		ingredient.save();
	}

	public static List<Partie> read() {
		return find.all();
	}

	public static void update(Partie updatedIngredient) {
		updatedIngredient.update();
	}

	public static void delete(Long iid) {
		find.ref(iid).delete();
	}

	public static Map<Long, String> getAllAsMap() {
		HashMap<Long, String> ingredientsMap = new HashMap<Long, String>();
		List<Partie> ingredients = Partie.read();
		for (Partie ingredient : ingredients) {
			ingredientsMap.put(ingredient.pid, ingredient.name);
		}
		return ingredientsMap;
	}
}