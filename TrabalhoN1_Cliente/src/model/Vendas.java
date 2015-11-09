package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vendas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Vendas {

	@XmlElement(name = "venda")
    private List<Venda> vendas = null;

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}  
	
	
	
}
