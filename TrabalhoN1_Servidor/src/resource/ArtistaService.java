package resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.*;

@Path("/artista")
public class ArtistaService {

	@GET
	@Path("/todos")
	@Produces("application/xml")
	public Artistas trazerArtistas() {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		return ld.getArtistas();
	}

	@GET
	@Path("/{id}")
	@Produces("application/xml")
	public Artista trazerArtista(@PathParam("id") int id) {
		Artistas artistas = trazerArtistas();
		for (Artista artista : artistas.getArtistas()) {
			if (artista.getId() == id) {
				return artista;
			}
		}
		return null;
	}

	@POST
	@Produces("application/xml")
	public void criarArtista(Artista artista) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		Artistas artistas = ld.getArtistas();
		if (artistas.getArtistas() == null) {
			artistas.setArtistas(new ArrayList<Artista>());
		}
		int id = 0;
		if (!artistas.getArtistas().isEmpty()) {
			id = artistas.getArtistas().get(artistas.getArtistas().size() - 1)
					.getId() + 1;
		}
		artista.setId(id);

		artistas.getArtistas().add(artista);
		LojaDiscosXML.gravarXML(ld);
	}

	@PUT
	@Produces("application/xml")
	public void editarArtista(Artista artista) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		List<Artista> listArtistas = ld.getArtistas().getArtistas();
	
		
		for (int i = 0; i < listArtistas.size(); i++) {
			if (listArtistas.get(i).getId() == artista.getId() ) {
				ld.getArtistas().getArtistas().set(i, artista);
				break;
			}
		}
		LojaDiscosXML.gravarXML(ld);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/xml")
	public void deletarArtista(@PathParam("id") int id) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		Artistas artistas = ld.getArtistas();
		if (artistas.getArtistas() == null) {
			artistas.setArtistas(new ArrayList<Artista>());
		}

		for (Artista a : artistas.getArtistas()) {
			if (a.getId() == id) {
				artistas.getArtistas().remove(a);
				break;
			}
		}
		LojaDiscosXML.gravarXML(ld);
	}

}
