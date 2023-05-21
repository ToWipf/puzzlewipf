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
public class PuzzleMain {

	public void doTest() throws IOException {
		System.out.println("START");

		SVGGraphics2D g2 = new SVGGraphics2D(500, 500);

		g2.drawRect(0, 0, 500, 500);

		g2.drawLine(0, 0, 500, 500);

		File f = new File("files/test1.svg");

		SVGUtils.writeToSVG(f, g2.getSVGElement());
	}

}
