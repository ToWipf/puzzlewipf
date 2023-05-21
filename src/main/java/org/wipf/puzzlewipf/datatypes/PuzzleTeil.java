package org.wipf.puzzlewipf.datatypes;

/**
 * @author devbuntu
 *
 */
public class PuzzleTeil {

	public enum verbindungsart {
		BUCHSE, STIFT, BLANK
	};

	public verbindungsart seiteA;
	public verbindungsart seiteB;
	public verbindungsart seiteC;
	public verbindungsart seiteD;

	/**
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 */
	public PuzzleTeil(verbindungsart A, verbindungsart B, verbindungsart C, verbindungsart D) {
		seiteA = A;
		seiteB = B;
		seiteC = C;
		seiteD = D;
	}

}
