package controllers;

import javax.inject.Inject;


import models.Ingredient;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class PartiesCtrl extends Controller {
 	
 	@Inject
 	private FormFactory formFactory;
 	
 	public Result createPartie() {
  		return ok(views.html.partiesForm.render("Create", formFactory.form(Partie.class)));
 	}
  
 	public Result readParties() {
  		return ok(views.html.parties.render(Partie.read()));
 	}
  
 	public Result updatePartie(Long partieID) {
  		Partie partie  = Partie.find.byId(partieID);
  		Form<Partie> filledForm = formFactory.form(Partie.class).fill(partie);
  		return ok(views.html.partiesForm.render("Update", filledForm));
 	}
  
 	public Result deletePartie(Long partieID) {
   // Fehlerabhandlung und Nutzerwarnung!
  		Partie.delete(iid);
  		return redirect(routes.PartiesCtrl.readparties());
 	}
  
 	public Result storeParties() {
  		Form<Partie> partiesForm = formFactory.form(Partie.class);
  		Form<Partie> filledForm = partiesForm.bindFromRequest();
  		if (filledForm.hasErrors()){
   			return ok(views.html.partiesForm.render("Correct", filledForm));
  		}
  		else {
   			Partie partie = filledForm.get();
   			if (partie.partieID == null){
    				Partie.create(partie);
   			} else {
    				Partie.update(partie);
   			}
   			return redirect(routes.PartiesCtrl.readparties());
  		}
 	}
}