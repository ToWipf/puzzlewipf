package org.wipf.puzzlewipf.rest.puzzle;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.wipf.puzzlewipf.logic.puzzle.PuzzleMain;

/**
 * @author wipf
 *
 */
@Path("puzzle")
//@RolesAllowed("admin")
@PermitAll
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PuzzleRest {

	@Inject
	PuzzleMain pm;

	@GET
	@Path("test")
	public Response test() throws IOException {
		pm.doTest();
		return Response.ok().build();
	}

}
