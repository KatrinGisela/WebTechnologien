package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;

import com.avaje.ebean.Model;

@Entity
public class Stadion extends Model {
	@Id
	public Long sid;
	@Required
	public String name;
	@Required
	public String adresse;
	@Required
	public int anzahlSitzplaetze;
	@Required
	public int anzahlEingaengeAusgaenge;
	@ManyToMany(cascade = CascadeType.REMOVE)
	public List<Partie> partien;
	public static Finder<Long, Stadion> find = new Finder<Long, Stadion>(
			Stadion.class);

	public static void create(Stadion stadion) {
		stadion.save();
	}

	public static List<Stadion> read() {
		return find.all();
	}

	public static void update(Stadion updatedStadion) {
		updatedStadion.update();

	}

	public static void delete(Long rid) {
		find.ref(rid).delete();
	}
}
