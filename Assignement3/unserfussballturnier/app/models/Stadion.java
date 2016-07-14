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
	@Id
	public Long sid;
	@Required
	public String name;
	@Required
	public String addresse;
	@Required
	public int anzahlSitzplaetze;
	@Required
	public int anzahlZugaenge;
	public String sponsor;
	@OneToMany(cascade = CascadeType.REMOVE)
	public List<Partie> parties;
	public static Finder<Long, Stadion> find = new Finder<Long, Stadion>(
			Stadion.class);

	public static void create(Stadion partie) {
		partie.save();
	}

	public static List<Stadion> read() {
		return find.all();
	}

	public static void update(Stadion updatePartie) {
		updatePartie.update();
	}

	public static void delete(Long rid) {
		find.byId(rid).delete();
	}
}
