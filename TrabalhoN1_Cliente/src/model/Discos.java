package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "discos")
@XmlAccessorType (XmlAccessType.FIELD)
public class Discos {

	@XmlElement(name = "disco")
    private List<Disco> discos = null;

	public List<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}  
	
	
	
}
