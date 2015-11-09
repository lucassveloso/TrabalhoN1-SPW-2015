package resource;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.*;

public class LojaDiscosXML {

	public static LojaDiscos lerXML() {
		try {
			File f = new File("lojaDiscos.xml");
			if(f.exists()){
			JAXBContext context = JAXBContext.newInstance(LojaDiscos.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (LojaDiscos) unmarshaller.unmarshal(new File(
					"lojaDiscos.xml"));
			}else{
				LojaDiscos lojaDeDiscos = new LojaDiscos(new Artistas(), new Discos(), new Vendas());
				gravarXML(lojaDeDiscos);
				return lojaDeDiscos;
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void gravarXML(LojaDiscos lojaDeDiscos) {
		try {
			JAXBContext context = JAXBContext.newInstance(LojaDiscos.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(lojaDeDiscos, new FileOutputStream(
					"lojaDiscos.xml"));
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
