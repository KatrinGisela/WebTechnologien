package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class Partie extends Model {
	@Id
	public Long pid;
	@Required
	public String name;
	public String description;
	public String heimmannschaftName;
	@Required
	public String gastmannschaftName;
	@Required
	public String partieDatum;
	@OneToOne(mappedBy = "parties")
	public List<Stadion> stadien;

	public static Finder<Long, Partie> find = new Finder<Long, Partie>(
			Partie.class);

	public static void create(Partie partie) {
		partie.save();
	}

	public static List<Partie> read() {
		return find.all();
	}

	public static void update(Partie updatedPartie) {
		updatedPartie.update();
	}

	public static void delete(Long pid) {
		find.ref(pid).delete();
	}

	public static Map<Long, String> getAllAsMap() {
		HashMap<Long, String> partiesMap = new HashMap<Long, String>();
		List<Partie> parties = Partie.read();
		for (Partie partie : parties) {
			partiesMap.put(partie.pid, partie.heimmannschaftName); // hier auch
																	// die
																	// anderen
																	// Attribute?
			partiesMap.put(partie.pid, partie.gastmannschaftName); // macht das
																	// Sinn so?
			partiesMap.put(partie.pid, partie.partieDatum); // macht das Sinn
															// so?
		}
		return partiesMap;
	}
}
