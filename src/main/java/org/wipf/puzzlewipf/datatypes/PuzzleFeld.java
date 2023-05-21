package org.wipf.puzzlewipf.datatypes;

import java.util.LinkedList;
import java.util.List;

/**
 * @author devbuntu
 *
 */
public class PuzzleFeld {

	private List<PuzzleTeil> teile = new LinkedList<>();

	/**
	 * @param t
	 * @return
	 */
	public boolean addTeil(PuzzleTeil t) {
		// Nur einzigartige Teile zulassen
		for (PuzzleTeil et : teile) {
			if (et.equals(t)) {
				return false;
			}

		}
		teile.add(t);
		return true;
	}

}
