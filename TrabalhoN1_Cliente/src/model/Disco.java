
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
    "titulo",
    "artista",
    "genero",
    "ano",
    "preco"
})
@XmlRootElement(name = "disco")
public class Disco {

	private int id;
    private String titulo;
    private Artista artista;
    private String genero;
    private int ano;
    private double preco;

 
    public Disco(){
    	
    }
    
    public Disco(int id, String titulo, Artista artista, String genero,
			int ano, double preco) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.ano = ano;
		this.preco = preco;
	}

public Disco( String titulo, Artista artista, String genero,
			int ano, double preco) {
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.ano = ano;
		this.preco = preco;
	}

	public int getId() {
        return id;
    }


    public void setId(int value) {
        this.id = value;
    }

   
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String value) {
        this.titulo = value;
    }

    
    public Artista getArtista() {
        return artista;
    }

   
    public void setArtista(Artista value) {
        this.artista = value;
    }

  
    public String getGenero() {
        return genero;
    }

 
    public void setGenero(String value) {
        this.genero = value;
    }

   
    public int getAno() {
        return ano;
    }

   
    public void setAno(int value) {
        this.ano = value;
    }

    
    public double getPreco() {
        return preco;
    }

   
    public void setPreco(double value) {
        this.preco = value;
    }


    
    

}
