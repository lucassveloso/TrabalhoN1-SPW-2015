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

@Path("/disco")
public class DiscoService {

	@GET
	@Path("/todos")
	@Produces("application/xml")
	public Discos trazerDiscos() {
		LojaDiscos ld = LojaDiscosXML.lerXML();;
		return ld.getDiscos();
	}

	@GET
	@Path("/{id}")
	@Produces("application/xml")
	public Disco trazerDisco(@PathParam("id") int id) {
		Discos discos = trazerDiscos();
		for (Disco disco : discos.getDiscos()) {
			if (disco.getId() == id) {
				return disco;
			}
		}
		return null;
	}
	
	@GET
	@Path("/artista/{nome}")
	@Produces("application/xml")
	public Discos trazerDiscoArtista(@PathParam("nome") String nome) {
		Discos discos = trazerDiscos();
		Discos discosResultado = new Discos();
		discosResultado.setDiscos(new ArrayList<Disco>());
		for (Disco disco : discos.getDiscos()) {
			if (disco.getArtista().getNome().equals(nome)) {
				discosResultado.getDiscos().add(disco);
			}
		}
		return discosResultado;
	}
	
	@GET
	@Path("/genero/{genero}")
	@Produces("application/xml")
	public Discos trazerDiscoGenero(@PathParam("genero") String genero) {
		Discos discos = trazerDiscos();
		Discos discosResultado = new Discos();
		discosResultado.setDiscos(new ArrayList<Disco>());
		for (Disco disco : discos.getDiscos()) {
			if (disco.getGenero().equals(genero)) {
				discosResultado.getDiscos().add(disco);
			}
		}
		return discosResultado;
	}
	
	@GET
	@Path("/ano/{ano}")
	@Produces("application/xml")
	public Discos trazerDiscoAno(@PathParam("ano") int ano) {
		Discos discos = trazerDiscos();
		Discos discosResultado = new Discos();
		discosResultado.setDiscos(new ArrayList<Disco>());
		for (Disco disco : discos.getDiscos()) {
			if (disco.getAno() == ano) {
				discosResultado.getDiscos().add(disco);
			}
		}
		return discosResultado;
	}

	@POST
	@Produces("application/xml")
	public void criarDisco(Disco disco) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		Discos discos = ld.getDiscos();
		if (discos.getDiscos() == null) {
			discos.setDiscos(new ArrayList<Disco>());
		}
		int id = 0;
		if (!discos.getDiscos().isEmpty()) {
			id = discos.getDiscos().get(discos.getDiscos().size() - 1)
					.getId() + 1;
		}
		disco.setId(id);

		discos.getDiscos().add(disco);
		LojaDiscosXML.gravarXML(ld);
	}

	@PUT
	@Produces("application/xml")
	public void editarDisco(Disco disco) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		List<Disco> listDiscos = ld.getDiscos().getDiscos();
	
		
		for (int i = 0; i < listDiscos.size(); i++) {
			if (listDiscos.get(i).getId() == disco.getId() ) {
				ld.getDiscos().getDiscos().set(i, disco);
				break;
			}
		}
		
		LojaDiscosXML.gravarXML(ld);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/xml")
	public void deletarDisco(@PathParam("id") int id) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		Discos discos = ld.getDiscos();
		if (discos.getDiscos() == null) {
			discos.setDiscos(new ArrayList<Disco>());
		}

		for (Disco a : discos.getDiscos()) {
			if (a.getId() == id) {
				discos.getDiscos().remove(a);
				break;
			}
		}
		LojaDiscosXML.gravarXML(ld);
	}

}
