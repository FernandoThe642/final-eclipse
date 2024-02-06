package ec.edu.ups.ppw63.demo63.services;

import java.util.List;

import ec.edu.ups.ppw63.demo63.business.GestionRecargas;
import ec.edu.ups.ppw63.demo63.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargaServices {
	
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try {
			gRecargas.guardarRecarga(recarga);
			return Response.ok(recarga).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Recarga recarga) {
		try {
			gRecargas.actualizarRecarga(recarga);
			return Response.ok(recarga).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@PathParam("id") int id) {
		try {
			gRecargas.borrarRecarga(id);
			return Response.ok().entity("Recarga eliminada con éxito").build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, "No se pudo eliminar la recarga");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer(@PathParam("id") int id) {
		try {
			Recarga recarga = gRecargas.leerRecarga(id);
			if (recarga != null) {
				return Response.ok(recarga).build();
			} else {
				ErrorMessage error = new ErrorMessage(4, "Recarga no encontrada");
				return Response.status(Response.Status.NOT_FOUND)
						.entity(error)
						.build();
			}
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas() {
		List<Recarga> recargas = gRecargas.getTodasLasRecargas();
		if (recargas != null && !recargas.isEmpty()) {
			return Response.ok(recargas).build();
		} else {
			ErrorMessage error = new ErrorMessage(6, "No hay recargas registradas");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	

}
