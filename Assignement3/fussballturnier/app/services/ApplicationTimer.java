package services;

import java.time.Clock;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import javax.inject.*;

import models.Ingredient;
import models.Recipe;
import play.Logger;
import play.inject.ApplicationLifecycle;

/**
 * This class demonstrates how to run code when the
 * application starts and stops. It starts a timer when the
 * application starts. When the application stops it prints out how
 * long the application was running for.
 *
 * This class is registered for Guice dependency injection in the
 * {@link Module} class. We want the class to start when the application
 * starts, so it is registered as an "eager singleton". See the code
 * in the {@link Module} class to see how this happens.
 *
 * This class needs to run code when the server stops. It uses the
 * application's {@link ApplicationLifecycle} to register a stop hook.
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

        // Create ingredients here:
        Ingredient paprika = new Ingredient();
        paprika.name = "Paprika";
        paprika.description = "Rotes Gemüse";
        Ingredient.create(paprika);
        
        Ingredient kartoffel = new Ingredient();
        kartoffel.name = "Kartoffel";
        kartoffel.description = "Wohlschmeckendes Nachtschattengewächs";
        Ingredient.create(kartoffel);
        
        Ingredient nudeln = new Ingredient();
        nudeln.name = "Nudeln";
        nudeln.description = "Schön al dente";
        Ingredient.create(nudeln);
        
        Recipe recipe = new Recipe();
        recipe.name = "Paprikanudeln";
        recipe.description = "Paprika und Nudeln kochen";
        recipe.ingredients.add(paprika);
        recipe.ingredients.add(nudeln);
        Recipe.create(recipe);
        
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
