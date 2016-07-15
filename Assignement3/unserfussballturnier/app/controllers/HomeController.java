package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Partie;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */

	public Result index() {
		return ok(views.html.index.render("Your new application is ready."));
	}

	/**
	 * Shows a date overview of all matches that are registered and that will
	 * take place containing information about the date of the match, the match
	 * members and the stadium
	 */
	public Result showDatesOverview() {
		List<Partie> partiesList = Partie.find.all();

		Map<Date, List<Partie>> myMap = new HashMap<Date, List<Partie>>();
		for (Partie p : partiesList) {
			Date instant = p.partieDatum;
			if (!myMap.containsKey(p.partieDatum)) {
				myMap.put(instant, new ArrayList<Partie>());
			}
			myMap.get(instant).add(p);

		}
		return ok(views.html.datumsuebersicht.render(myMap));

	}
}
