package models;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;

public class Partie extends Model   {
  
 	
 	@Id
 	public Long PartieID;
 	@Required
 	public String nameHeimat; 
  @Required	  
  public String nameGast   ; 
  @Required  
  public String datum;
  @OneToOne(mappedBy = "parties")
  // gibts OneToOne??
 	public List<Stadium> stadiums;    // überprüfen, ob Namen matchen (zudem grammatikalisch inkorrekt)
  
 	public static Finder<Long, Partie> find = new Finder<Long, Partie>(Partie.class);
  
 	public static void create(Partie partie) {
    	// if (mindestens ein Stadion existiert in der Datenbank)
      Partie partie = Form.form(Partie.class).bindFromRequest().get();  // das hier evtl auch? Oder in Ctrl?
  		partie.save();
     return redirect(routes.Partie.index());
 	}
  
 	  public static List<Partie> read() {
    List<Partie> parties = new Model.Finder(String.class, Partie.class).all(); // Laut Tutorial (aber in Ctrl)
  		return find.all();
  	}
  
 	public static void update(Partie updatedParties) {
  		updatedPartie.update();
 	}
  
 	public static void delete(Long PartieID) {
    find.ref(PartieID).delete();
 	}
  
 	public static Map<Long, String> getAllAsMap() {
  		HashMap<Long, String> partiesMap = new HashMap<Long, String>();
  		List<Partie> parties = Partie.read();
  		for (Partie partie : parties) {
      		
   			partiesMap.put(partie.partieID, partie.nameHeimat, partie.nameGast, partie.datum );
  		}
    		return partiesMap;
 	}
}
  }