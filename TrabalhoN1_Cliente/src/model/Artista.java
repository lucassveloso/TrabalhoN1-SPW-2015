package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "nome"
})
@XmlRootElement(name = "artista")
public class Artista {

    private int id;
    private String nome;

	public Artista(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Artista(){
		
	}
	public Artista(String nome) {
		this.nome = nome;
	}
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
        return nome;
    }
    public void setNome(String value) {
        this.nome = value;
    }
	

    
}