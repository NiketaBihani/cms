package com.hmh.automation.pages;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Manifest {
	
	String name;
	int age;
	int id;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	
	public void manObjToXML(String loc, int id, String name, int age){

		  String actualPath= System.getProperty("user.dir");
		  String st=loc;
		  loc=actualPath+loc;
		  Manifest customer = new Manifest();
		  customer.setId(id);
		  customer.setName(name);
		  customer.setAge(age);

		  try {

			File file = new File(loc+st+".xml");
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