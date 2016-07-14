package models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class Partie extends Model {
	@Id
	public Long pid;
	@Required
	public String heimmannschaftName;
	@Required
	public String gastmannschaftName;
	@Required
	@Formats.DateTime(pattern = "yyyy-mm-dd")
	public LocalDate partieDatum;
	@ManyToOne
	public Stadion stadion;
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

	/*
	 * public static Map<Long, String> getAllAsMap() { HashMap<Long, String>
	 * partiesMap = new HashMap<Long, String>(); List<Partie> parties =
	 * Partie.read(); for (Partie partie : parties) { partiesMap.put(partie.pid,
	 * partie.heimmannschaftName); partiesMap.put(partie.pid,
	 * partie.gastmannschaftName); partiesMap.put(partie.pid,
	 * partie.partieDatum); } return partiesMap; }
	 */
}
