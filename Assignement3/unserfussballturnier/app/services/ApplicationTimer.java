package services;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Partie;
import models.Stadion;
import play.Logger;
import play.api.inject.Module;
import play.inject.ApplicationLifecycle;

/**
 * This class demonstrates how to run code when the application starts and
 * stops. It starts a timer when the application starts. When the application
 * stops it prints out how long the application was running for.
 * 
 * This class is registered for Guice dependency injection in the {@link Module}
 * class. We want the class to start when the application starts, so it is
 * registered as an "eager singleton". See the code in the {@link Module} class
 * to see how this happens.
 * 
 * This class needs to run code when the server stops. It uses the application's
 * {@link ApplicationLifecycle} to register a stop hook.
 */
@Singleton
public class ApplicationTimer {

	private final Clock clock;
	private final ApplicationLifecycle appLifecycle;
	private final Instant start;

	@Inject
    public ApplicationTimer(Clock clock, ApplicationLifecycle appLifecycle) {
        this.clock = clock;
        this.appLifecycle = appLifecycle;
        // This code is called when the application starts.
        start = clock.instant();
        Logger.info("ApplicationTimer demo: Starting application at " + start);

        // Create matches here:
        Partie halbfinale = new Partie();
        halbfinale.heimmannschaftName = "Inter";
        halbfinale.gastmannschaftName = "Roma";
        halbfinale.partieDatum = LocalDate.parse("2017-06-02") ;
        Partie.create(halbfinale);
        
        Partie viertelfinale = new Partie();
        viertelfinale.heimmannschaftName = "Lazio";
        viertelfinale.gastmannschaftName = "Juve";
        viertelfinale.partieDatum = LocalDate.parse("2017-04-25");
        Partie.create(viertelfinale);
        
        Partie achtelfinale = new Partie();
        achtelfinale.heimmannschaftName = "Parma";
        achtelfinale.gastmannschaftName = "Bologna";
        achtelfinale.partieDatum = LocalDate.parse("2017-09-20");
        Partie.create(achtelfinale);
        
        Stadion stadion = new Stadion();
        stadion.name = "Stadio Olimpico";
        stadion.addresse = "Roma"; 
        stadion.anzahlSitzplaetze = 5000; 
        stadion.anzahlZugaenge = 10; 
        stadion.parties.add(halbfinale);
        Stadion.create(stadion);
        
        Stadion sanSiro = new Stadion();
        sanSiro.name = "San Siro";
        sanSiro.addresse = "Milano";
        sanSiro.anzahlSitzplaetze = 10000;
        sanSiro.anzahlZugaenge = 50;  
        sanSiro.parties.add(viertelfinale);
        sanSiro.parties.add(achtelfinale);
        Stadion.create(sanSiro);
        
        
        // When the application starts, register a stop hook with the
        // ApplicationLifecycle object. The code inside the stop hook will
        // be run when the application stops.
        appLifecycle.addStopHook(() -> {
            Instant stop = clock.instant();
            Long runningTime = stop.getEpochSecond() - start.getEpochSecond();
            Logger.info("ApplicationTimer demo: Stopping application at " + clock.instant() + " after " + runningTime + "s.");
            return CompletableFuture.completedFuture(null);
        });
    }
}
