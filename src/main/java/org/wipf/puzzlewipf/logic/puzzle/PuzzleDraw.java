package org.wipf.puzzlewipf.logic.puzzle;

import java.io.File;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

/**
 * @author devbuntu
 *
 */
@ApplicationScoped
public class PuzzleDraw {

	public void drawTest() throws IOException {
		System.out.println("START");

		Integer height_y = 4;
		Integer weight_x = 3;
		Integer scale = 10;

		SVGGraphics2D g2 = new SVGGraphics2D(weight_x * scale, height_y * scale);

		for (int x = 0; x < weight_x; x++) {
			for (int y = 0; y < height_y; y++) {
				System.out.println("Quadrat X: " + x + " Y: " + y);

				g2 = doDrawVert(g2, x * scale, y * scale, scale);
				g2 = doDrawHor(g2, x * scale, y * scale, scale);

				g2 = doDrawVert(g2, (x * scale) + scale, (y * scale) + scale, -scale);
				g2 = doDrawHor(g2, (x * scale) + scale, (y * scale) + scale, -scale);

			}
		}

		File f = new File("files/test1.svg");

		SVGUtils.writeToSVG(f, g2.getSVGElement());
	}

	/**
	 * @param g
	 * @param x
	 * @param y
	 * @param len
	 * @return
	 */
	private SVGGraphics2D doDrawVert(SVGGraphics2D g, int x, int y, int len) {
		g.drawLine(x, y, len + x, y);
		return g;
	}

	/**
	 * @param g
	 * @param x
	 * @param y
	 * @param len
	 * @return
	 */
	private SVGGraphics2D doDrawHor(SVGGraphics2D g, int x, int y, int len) {
		g.drawLine(x, y, x, len + y);
		return g;
	}

}
