package controller;



import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.*;

import model.*;

public class ArtistaController {

	public final String URL = "http://localhost:8080/TrabalhoN1_Alexandre_Lucas_Servidor";
	
	public Artistas trazerArtistas(){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/artista/todos");
		Response response =  target.request().get();
		Artistas a = response.readEntity(Artistas.class);
		return a;
	}
	
	public Artista trazerArtista(Artista artista){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/artista/"+artista.getId());
		Response response =  target.request().get();
		Artista a = response.readEntity(Artista.class);
		return a;
	}
	
	public void criarArtista(Artista artista) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/artista");
		target.request().post(Entity.entity(artista, "application/xml"));
	}

	public void editarArtista(Artista artista) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/artista");
		target.request().put(Entity.entity(artista, "application/xml"));
		
	}
	
	public void deletarArtista(int id) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/artista/"+id);
		target.request().delete();
		
	}

}
