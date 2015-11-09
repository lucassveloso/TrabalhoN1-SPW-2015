package controller;



import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.*;

import model.*;

public class VendaController {

	public final String URL = "http://localhost:8080/TrabalhoN1_Alexandre_Lucas_Servidor";
	
	public Vendas trazerVendas(){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/venda/todos");
		Response response =  target.request().get();
		Vendas a = response.readEntity(Vendas.class);
		return a;
	}
	
	public Venda trazerVenda(Venda Venda){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/venda/"+Venda.getId());
		Response response =  target.request().get();
		Venda a = response.readEntity(Venda.class);
		return a;
	}
	
	public void criarVenda(Venda Venda) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/venda");
		target.request().post(Entity.entity(Venda, "application/xml"));
	}

	public void editarVenda(Venda Venda) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/venda");
		target.request().put(Entity.entity(Venda, "application/xml"));
		
	}
	
	public void deletarVenda(int id) throws Exception {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client
				.target(URL + "/venda/"+id);
		target.request().delete();
		
	}

}
