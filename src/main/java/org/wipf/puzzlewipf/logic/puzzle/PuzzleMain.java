package org.wipf.puzzlewipf.logic.puzzle;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.wipf.puzzlewipf.datatypes.PuzzleFeld;
import org.wipf.puzzlewipf.datatypes.PuzzleTeil;
import org.wipf.puzzlewipf.datatypes.PuzzleTeil.verbindungsart;

/**
 * @author devbuntu
 *
 */
@ApplicationScoped
public class PuzzleMain {

	@Inject
	PuzzleDraw draw;

	public void doTest() throws IOException {
		System.out.println("START");

		PuzzleFeld f = new PuzzleFeld();

		f.addTeil(new PuzzleTeil(verbindungsart.BUCHSE, verbindungsart.BUCHSE, verbindungsart.BUCHSE, verbindungsart.BUCHSE));

	}

}
