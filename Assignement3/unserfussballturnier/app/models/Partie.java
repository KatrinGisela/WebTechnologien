package models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class Partie extends Model {
	/**
	 * pid the partie id
	 */
	@Id
	public Long pid;

	/**
	 * String heimmannschaftName the name of the home team
	 */
	@Required
	public String heimmannschaftName;

	/**
	 * String gastmannschaftName the name of the visiting team
	 */
	@Required
	public String gastmannschaftName;

	/**
	 * LocalDate partieDatum the date of the partie
	 */
	@Required
	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date partieDatum;

	/**
	 * Stadion stadion the stadion where the parties take place
	 */
	@ManyToOne
	public Stadion stadion;

	public static Finder<Long, Partie> find = new Finder<Long, Partie>(
			Partie.class);

	/**
	 * Creates a new partie and saves it.
	 * 
	 * @param partie
	 *            the partie that the user wants to create.
	 */
	public static void create(Partie partie) {
		partie.save();
	}

	/**
	 * Reads and displays all existing parties.
	 * 
	 * @return all existing parties
	 */
	public static List<Partie> read() {
		return find.all();
	}

	/**
	 * Updates the partie information with the user inputs
	 * 
	 * @param pid
	 *            the partie id of the partie that is to be updated
	 */
	public static void update(Partie updatePartie) {
		updatePartie.update();
	}

	/**
	 * Deletes the chosen partie if it existst in the database
	 * 
	 * @param pid
	 *            the partie id of the partie that is to be deleted
	 */
	public static void delete(Long pid) {
		find.byId(pid).delete();
	}

	/**
	 * Creates a map of all parties containing the names of the partie members,
	 * the date of the partie and the stadium id.
	 * 
	 * @return the map of the parties
	 */
	public static Map<Long, String> getAllAsMap() {
		HashMap<Long, String> partiesMap = new HashMap<Long, String>();
		List<Partie> parties = Partie.read();
		for (Partie partie : parties) {
			partiesMap.put(partie.pid, partie.heimmannschaftName);
			partiesMap.put(partie.pid, partie.gastmannschaftName);
			partiesMap.put(partie.pid, partie.partieDatum.toString());
			partiesMap.put(partie.pid, partie.stadion.sid.toString());
		}
		return partiesMap;
	}

}
