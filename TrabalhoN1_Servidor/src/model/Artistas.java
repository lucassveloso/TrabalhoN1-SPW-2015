package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "artistas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Artistas {

	@XmlElement(name = "artista")
    private List<Artista> artistas = null;

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}  
	
	
	
}
