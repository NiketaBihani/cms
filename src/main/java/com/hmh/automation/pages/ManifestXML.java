package com.hmh.automation.pages;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.RandomStringUtils;

public class ManifestXML {


	public void manObjToXML(String loc, int id, String name, int age){

		  String actualPath= System.getProperty("user.dir");
		  loc=actualPath+loc+"commonCartridgeManifest";
		  Manifest customer = new Manifest();
		  customer.setId(id);
		  customer.setName(name);
		  customer.setAge(age);
		  String stName= RandomStringUtils.randomAlphanumeric(5);

		  try {

			File file = new File(loc+stName+".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Manifest.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		      } 
		  
		  catch (JAXBException e) {
		    	  e.printStackTrace();
		      }

	}
	
}