package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "lojaDiscos")
@XmlAccessorType (XmlAccessType.FIELD)
public class LojaDiscos {
	    @XmlElement(name = "artistas")
	    private Artistas artistas;  
	    @XmlElement(name = "discos")
	    private Discos discos;	  
	    @XmlElement(name = "vendas")
	    private Vendas vendas;

	    public LojaDiscos(){	
		}

	    
		public LojaDiscos(Artistas artistas, Discos discos, Vendas vendas) {
			super();
			this.artistas = artistas;
			this.discos = discos;
			this.vendas = vendas;
		}


		public Artistas getArtistas() {
			return artistas;
		}

		public void setArtistas(Artistas artistas) {
			this.artistas = artistas;
		}

		public Discos getDiscos() {
			return discos;
		}

		public void setDiscos(Discos discos) {
			this.discos = discos;
		}

		public Vendas getVendas() {
			return vendas;
		}

		public void setVendas(Vendas vendas) {
			this.vendas = vendas;
		}
		
		
		
		
	 
}
