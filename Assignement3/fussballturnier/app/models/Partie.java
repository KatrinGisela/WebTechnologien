package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Partie extends Model {
	@Id
	public Long pid;
	@Required
	public String heimmannschaftName;
	@Required
	public String gastmannschaftName;
	@Required
	public String partieDatum;
	@ManyToOne(mappedBy = "partien")
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
		HashMap<Long, String> partienMap = new HashMap<Long, String>();
		List<Partie> partien = Partie.read();
		for (Partie partie : partien) {
			partienMap.put(partie.pid, partie.name);
		}
		return partienMap;
	}
}