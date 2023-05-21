package org.wipf.jasmarty.logic.base;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TimeZone;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

/**
 * @author wipf
 *
 */
@ApplicationScoped
public class MainHome {

	@Inject
	WipfConfigVW wipfConfig;
	@Inject
	WipfUserVW wipfUserVW;

	private static final Logger LOGGER = Logger.getLogger("_MainHome_");
	public static final String VERSION = "0.0.01";

	/**
	 * Stop App
	 */
	public static void stopApp() {
		LOGGER.info("Stoppen...");
		Quarkus.asyncExit();
	}

	/**
	 * @param ev
	 */
	void onStart(@Observes StartupEvent ev) {
		LOGGER.info("Starte " + VERSION);
		LOGGER.debug("Debug Log aktiv");
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
		// LOGGER.info("Tmp Ordner: " + System.getProperty("java.io.tmpdir"));
		createFileFolder();

		wipfUserVW.crateDefaultUsers();

		if (wipfConfig.isAppActive("wipf")) {
			wipfConfig.checkAppWorkId();
		}

		if (wipfConfig.isAppActive("eisenbahn_mitlesen")) {
			System.out.println("eisenbahn_mitlesen aktiv");
		}

		LOGGER.info("Gestartet");
	}

	/**
	 * @param ev
	 */
	void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("Stoppe");

		LOGGER.info("Gestoppt");
	}

	/**
	 * 
	 */
	private void createFileFolder() {
		// Fileorder erstellen
		try {
			Path path = Paths.get(Paths.get("").toAbsolutePath().toString() + "/files");
			Files.createDirectories(path);
		} catch (Exception e) {
			LOGGER.error("createFileFolder");
		}

	}

}