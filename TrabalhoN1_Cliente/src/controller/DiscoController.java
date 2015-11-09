package controller;



import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.*;

import model.*;

public class DiscoController {

	public final String URL = "http://localhost:8080/TrabalhoN1_Alexandre_Lucas_Servidor";
	
	public Discos trazerDiscos(){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco/todos");
		Response response =  target.request().get();
		Discos a = response.readEntity(Discos.class);
		return a;
	}
	
	public Disco trazerDisco(Disco Disco){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco/"+Disco.getId());
		Response response =  target.request().get();
		Disco a = response.readEntity(Disco.class);
		return a;
	}
	
        public Discos buscarDiscoArtista(Disco Disco){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco/artista/"+Disco.getArtista().getNome());
		Response response =  target.request().get();
		Discos a = response.readEntity(Discos.class);
		return a;
	}
        
         public Discos buscarDiscoGenero(Disco Disco){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco/genero/"+Disco.getGenero());
		Response response =  target.request().get();
		Discos a = response.readEntity(Discos.class);
		return a;
	}
         
          public Discos buscarDiscoAno(Disco Disco){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco/ano/"+Disco.getAno());
		Response response =  target.request().get();
		Discos a = response.readEntity(Discos.class);
		return a;
	}
        
	public void criarDisco(Disco Disco) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco");
		target.request().post(Entity.entity(Disco, "application/xml"));
	}

	public void editarDisco(Disco Disco) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco");
		target.request().put(Entity.entity(Disco, "application/xml"));
		
	}
	
	public void deletarDisco(int id) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/disco/"+id);
		target.request().delete();
		
	}

}
