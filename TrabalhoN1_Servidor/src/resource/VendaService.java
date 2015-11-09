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

@Path("/venda")
public class VendaService {

	@GET
	@Path("/todos")
	@Produces("application/xml")
	public Vendas trazerVendas() {
		LojaDiscos ld = LojaDiscosXML.lerXML();;
		return ld.getVendas();
	}

	@GET
	@Path("/{id}")
	@Produces("application/xml")
	public Venda trazerVenda(@PathParam("id") int id) {
		Vendas Vendas = trazerVendas();
		for (Venda Venda : Vendas.getVendas()) {
			if (Venda.getId() == id) {
				return Venda;
			}
		}
		return null;
	}

	@POST
	@Produces("application/xml")
	public void criarVenda(Venda Venda) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		Vendas Vendas = ld.getVendas();
		if (Vendas.getVendas() == null) {
			Vendas.setVendas(new ArrayList<Venda>());
		}
		int id = 0;
		if (!Vendas.getVendas().isEmpty()) {
			id = Vendas.getVendas().get(Vendas.getVendas().size() - 1)
					.getId() + 1;
		}
		Venda.setId(id);

		Vendas.getVendas().add(Venda);
		LojaDiscosXML.gravarXML(ld);
	}

	@PUT
	@Produces("application/xml")
	public void editarVenda(Venda Venda) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		List<Venda> listVendas = ld.getVendas().getVendas();
	
		
		for (int i = 0; i < listVendas.size(); i++) {
			if (listVendas.get(i).getId() == Venda.getId() ) {
				ld.getVendas().getVendas().set(i, Venda);
				break;
			}
		}
		
		LojaDiscosXML.gravarXML(ld);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/xml")
	public void deletarVenda(@PathParam("id") int id) {
		LojaDiscos ld = LojaDiscosXML.lerXML();
		Vendas Vendas = ld.getVendas();
		if (Vendas.getVendas() == null) {
			Vendas.setVendas(new ArrayList<Venda>());
		}

		for (Venda a : Vendas.getVendas()) {
			if (a.getId() == id) {
				Vendas.getVendas().remove(a);
				break;
			}
		}
		LojaDiscosXML.gravarXML(ld);
	}

}
