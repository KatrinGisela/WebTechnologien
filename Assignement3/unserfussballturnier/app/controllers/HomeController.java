package controllers;

import java.time.Instant;

import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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

	// public Result index() {
	// return ok(index.render("Your new application is ready."));
	// }
	// public Result index() {
	// return ok(index.render("Your new application is ready."));
	// }

	/**
	 * Es muss von der Startseite aus eine „Terminansicht“ aufrufbar sein. Diese
	 * Ansicht ist nach den Stadien, sondern nach den Daten, an denen Partien
	 * stattfinden, gruppiert und sortiert. Unterhalb jedes Datums stehen dann
	 * jeweils alle Partien (Mannschaften und Name des Stadions), die an einem
	 * Tag stattfinden.
	 */
	public Result showDatesOverview() {
		List<Partie> partiesList = Partie.find.all();

		// durch PartiesList durchlaufen
		// existiert bereits eine Partie? Wenn ja, fügen wir das hinzu,

		Map<Date, List<Partie>> myMap = new HashMap<Date, List<Partie>>();

		// TODO: Sortieren!!!

		for (Partie p : partiesList) {
			// Instant instant =
			// p.partieDatum.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			Date instant = p.partieDatum;
			if (!myMap.containsKey(p.partieDatum)) {
				// myMap.put(Date.from(instant), new ArrayList<Partie>());
				// //VERSION DO MORGEN
				myMap.put(instant, new ArrayList<Partie>());
			}
			// myMap.get(Date.from(instant)).add(p); //VERSION DO MORGEN
			myMap.get(instant).add(p);
		}

		// Partie partiesPerDate = (Partie) Partie.find.orderBy(DATE);

		// partiesList.sort(new Comparator<Partie>() {
		//
		// @Override
		// public int compare(Partie o1, Partie o2) {
		// return o1.partieDatum.compareTo((ChronoLocalDate) o2);
		// }
		// });
		System.out.println(instant);
		// Instant instant =
		// p.partieDatum.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date instant = p.partieDatum;
		if (!myMap.containsKey(p.partieDatum)) {
			myMap.put(instant, new ArrayList<Partie>());
		}
		myMap.get(instant).add(p);
	}

	// Partie partiesPerDate = (Partie) Partie.find.m
	// Partie partiesPerDate = (Partie) Partie.find.orderBy(DATE);

	// partiesList.sort(new Comparator<Partie>() {
	//
	// @Override
	// public int compare(Partie o1, Partie o2) {
	// return o1.partieDatum.compareTo((ChronoLocalDate) o2);
	// }
	// });

	return ok(views.html.datumsuebersicht.render(myMap);
	
		

