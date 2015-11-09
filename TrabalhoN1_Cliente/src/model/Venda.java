
package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "discos",
    "valorTotal"
})
@XmlRootElement(name = "venda")
public class Venda {

	private int id;
    private List<Disco> discos;
    private double valorTotal;

 
    public Venda(){
    	
    }
    
	public Venda(int id, List<Disco> discos, double valorTotal) {
		super();
		this.id = id;
		this.discos = discos;
		this.valorTotal = valorTotal;
	}




	public int getId() {
        return id;
    }


    public void setId(int value) {
        this.id = value;
    }

	public List<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}




	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

   
  
}
