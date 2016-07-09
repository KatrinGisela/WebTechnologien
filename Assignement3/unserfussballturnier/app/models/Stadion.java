package models;

import java.util.List;


import javax.persistence.*;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

@Entity
public class Stadion extends Model {
	@Id
	public Long sid;
	@Required
	public String name;
	public String description;
	@ManyToMany(cascade = CascadeType.REMOVE)
	public List<Partie> parties;
	public static Finder<Long, Stadion> find = new Finder<Long,Stadion>(Stadion.class);

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
		find.ref(rid).delete();
	}
}
