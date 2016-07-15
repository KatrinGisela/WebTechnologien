package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class Stadion extends Model {
	/**
	 * Long sid the id of the stadium
	 */
	@Id
	public Long sid;
	
	/**
	 * String name the name of the stadium
	 */
	@Required
	public String name;
	
	/**
	 * String addresse the adress of the stadium
	 */
	@Required
	public String addresse;
	
	
	/**
	 * int anzahlSitzplaetze the amount of seats of the certain stadium
	 */
	@Required
	public int anzahlSitzplaetze;
	
	
	/**
	 * int anzahlZugaenge the amount of entrances
	 */
	@Required
	public int anzahlZugaenge;
	
	
	/**
	 * String sponsor the name of the sponsonr
	 */
	public String sponsor;
	
	/**
	 * List<Partie> parties a list of all parties
	 */
	@OneToMany(cascade = CascadeType.REMOVE)
	public List<Partie> parties;


	public static Finder<Long, Stadion> find = new Finder<Long, Stadion>(
			Stadion.class);

	/**
	 * Creates and saves a new stadium.
	 * @param stadion the stadion that is to be created
	 */
	public static void create(Stadion stadion) {
		stadion.save();
	}

	/**
	 * Reads and displays all stadium
	 */
	public static List<Stadion> read() {
		return find.all();
	}

	/**
	 * Updates the stadium information with the user inputs
	 * 
	 * @param updateStadion
	 *            the stadium that is to be updated
	 */
	public static void update(Stadion updateStadion) {
		updateStadion.update();
	}

	/**
	 * Deletes the chosen stadium
	 * 
	 * @param sid
	 *            the stadium id of the stadium that is to be deleted
	 */
	public static void delete(Long sid) {
		find.byId(sid).delete();
	}
}
