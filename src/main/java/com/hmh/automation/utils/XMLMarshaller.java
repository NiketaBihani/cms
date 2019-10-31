/*
 * Author: Abhinav Kumar Mishra
 * Copyright &COPY; 2018 Houghton Mifflin Harcourt. All rights reserved.
 */
package com.hmh.automation.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;

/**
 * The Class XMLMarshaller.
 */
public final class XMLMarshaller {
	
	/**
	 * The Constructor.
	 */
	private XMLMarshaller() {
		super();
	}

	/**
	 * Marshal object to file.
	 *
	 * @param anObject the an object
	 * @param fileObj the file obj
	 * @throws JAXBException the JAXB exception
	 * @throws PropertyException the property exception
	 */
	public static void marshalObjectToFile(final Object anObject,
			final File fileObj) throws JAXBException, PropertyException {
		marshalObjectToFile(anObject, fileObj, null,false);
	}
	
	/**
	 * Marshal object to file.
	 *
	 * @param anObject the an object
	 * @param fileObj the file obj
	 * @param encodingStr the encoding str
	 * @throws JAXBException the JAXB exception
	 * @throws PropertyException the property exception
	 */
	public static void marshalObjectToFile(final Object anObject,
			final File fileObj, final String encodingStr) throws JAXBException,
			PropertyException {
		marshalObjectToFile(anObject, fileObj, encodingStr, false);
	}
	
	/**
	 * Marshal object to file.
	 *
	 * @param anObject the an object
	 * @param fileObj the file obj
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @throws JAXBException the JAXB exception
	 * @throws PropertyException the property exception
	 */
	public static void marshalObjectToFile(final Object anObject,
			final File fileObj, final boolean ommitXmlDeclaration)
			throws JAXBException, PropertyException {
		marshalObjectToFile(anObject, fileObj, null, ommitXmlDeclaration);
	}
	
	
	/**
	 * Marshal object to string.
	 *
	 * @param anObject the an object
	 * @return the string
	 * @throws JAXBException the JAXB exception
	 * @throws IOException the IO exception
	 */
	public static String marshalObjectToString(final Object anObject)
			throws JAXBException, IOException {
		return marshalObjectToString(anObject, null,false);
	}
	
	/**
	 * Marshal object to string.
	 *
	 * @param anObject the an object
	 * @param encodingStr the encoding str
	 * @return the string
	 * @throws JAXBException the JAXB exception
	 * @throws IOException the IO exception
	 */
	public static String marshalObjectToString(final Object anObject,
			final String encodingStr) throws JAXBException, IOException {
		return marshalObjectToString(anObject, encodingStr,false);
	}
	
	/**
	 * Marshal object to string.
	 *
	 * @param anObject the an object
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @return the string
	 * @throws JAXBException the JAXB exception
	 * @throws IOException the IO exception
	 */
	public static String marshalObjectToString(final Object anObject,
			final boolean ommitXmlDeclaration) throws JAXBException, IOException {
		return marshalObjectToString(anObject, null, ommitXmlDeclaration);
	}
	
	/**
	 * Marshal object to string.
	 *
	 * @param anObject the an object
	 * @param encodingStr the encoding str
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @return the string
	 * @throws JAXBException the JAXB exception
	 * @throws IOException the IO exception
	 */
	public static String marshalObjectToString(final Object anObject,
			final String encodingStr, final boolean ommitXmlDeclaration)
			throws JAXBException, IOException {
		String xmlStr = StringUtils.EMPTY;
		final JAXBContext context = JAXBContext.newInstance(anObject.getClass());
		final Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		if(ommitXmlDeclaration){
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, ommitXmlDeclaration);
		}
		if(StringUtils.isNotBlank(encodingStr)){
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encodingStr);
		}
		try (final StringWriter strRw = new StringWriter();) {
			jaxbMarshaller.marshal(anObject, strRw);
			xmlStr = strRw.toString();
		}
		return xmlStr;
	}
	
	/**
	 * Marshal object to file.
	 *
	 * @param anObject the an object
	 * @param fileObj the file obj
	 * @param encodingStr the encoding str
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @throws JAXBException the JAXB exception
	 * @throws PropertyException the property exception
	 */
	public static void marshalObjectToFile(final Object anObject,
			final File fileObj, final String encodingStr,
			final boolean ommitXmlDeclaration) throws JAXBException,
			PropertyException {
		final JAXBContext jaxbContext = JAXBContext.newInstance(anObject.getClass());
		final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		if(ommitXmlDeclaration){
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, ommitXmlDeclaration);
		}
		if(StringUtils.isNotBlank(encodingStr)){
		  jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encodingStr);
		}
		jaxbMarshaller.marshal(anObject, fileObj);
	}
	
	/**
	 * Marshal object to writer.
	 *
	 * @param anObject the an object
	 * @param encodingStr the encoding str
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @return the string writer
	 * @throws JAXBException the JAXB exception
	 * @throws IOException the IO exception
	 */
	public static StringWriter marshalObjectToWriter(final Object anObject,
			final String encodingStr, final boolean ommitXmlDeclaration)
			throws JAXBException, IOException {
		final JAXBContext context = JAXBContext.newInstance(anObject.getClass());
		final Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		if(ommitXmlDeclaration){
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, ommitXmlDeclaration);
		}
		if(StringUtils.isNotBlank(encodingStr)){
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encodingStr);
		}
		final StringWriter strRw = new StringWriter();
		jaxbMarshaller.marshal(anObject, strRw);
		return strRw;
	}
	
	/**
	 * Write dom to file.
	 *
	 * @param fileName the file name
	 * @param doc the doc
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerException the transformer exception
	 */
	public static void writeDomToFile(final String fileName, final Document doc)
			throws TransformerFactoryConfigurationError, TransformerException {
		writeDomToFile(fileName, doc, false);
	}
	
	/**
	 * Write dom to string.
	 *
	 * @param doc the doc
	 * @return the string
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerException the transformer exception
	 */
	public static String writeDomToString(final Document doc)
			throws TransformerFactoryConfigurationError, TransformerException {
		return writeDomToString(doc, false);
	}
	
	/**
	 * Write dom to file.
	 *
	 * @param fileName the file name
	 * @param doc the doc
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerException the transformer exception
	 */
	public static void writeDomToFile(final String fileName,
			final Document doc, final boolean ommitXmlDeclaration)
			throws TransformerFactoryConfigurationError, TransformerException {
		final Transformer transformer = TransformerFactory.newInstance().newTransformer();
		if (ommitXmlDeclaration) {
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		}
		final Result hierarchyXML = new StreamResult(new File(fileName));
		final Source hierarchyInput = new DOMSource(doc);
		transformer.transform(hierarchyInput, hierarchyXML);
	}
	
	/**
	 * Write dom to string.
	 *
	 * @param doc the doc
	 * @param ommitXmlDeclaration the ommit xml declaration
	 * @return the string
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerException the transformer exception
	 */
	public static String writeDomToString(final Document doc,
			final boolean ommitXmlDeclaration)
			throws TransformerFactoryConfigurationError, TransformerException {
		final DOMSource domSource = new DOMSource(doc);
		final StringWriter writer = new StringWriter();
		final StreamResult result = new StreamResult(writer);
		final Transformer transformer = TransformerFactory.newInstance().newTransformer();
		if (ommitXmlDeclaration) {
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		}
		transformer.transform(domSource, result);
		return writer.toString();
	}
}
