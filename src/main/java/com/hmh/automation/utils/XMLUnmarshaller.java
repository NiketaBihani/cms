/*
 * Author: Abhinav Kumar Mishra
 * Copyright &COPY; 2018 Houghton Mifflin Harcourt. All rights reserved.
 */
package com.hmh.automation.utils;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 * The Class XMLUnmarshaller.
 */
public final class XMLUnmarshaller {
 
	/**
	 * The Constructor.
	 */
	private XMLUnmarshaller(){
		super();
	}
	
	/**
	 * Convert xml string to jaxb object.
	 *
	 * @param xmlAsStr the xml as str
	 * @param aClass the a class
	 * @return the object
	 * @throws JAXBException the JAXB exception
	 */
	public static Object convertXmlStringToJaxbObject(final String xmlAsStr,
			final Class<?> aClass) throws JAXBException {
		final StreamSource streamSource = new StreamSource(new StringReader(xmlAsStr));
		return getJaxbObject(streamSource, aClass);
	}
	
	/**
	 * Convert xml input stream to jaxb object.
	 *
	 * @param inStream the in stream
	 * @param aClass the a class
	 * @return the object
	 * @throws JAXBException the JAXB exception
	 */
	public static Object convertXmlInputStreamToJaxbObject(final InputStream inStream,
			final Class<?> aClass) throws JAXBException {
		final StreamSource streamSource = new StreamSource(inStream);
		return getJaxbObject(streamSource, aClass);
	}
		
	/**
	 * Convert xml file to jaxb object.
	 *
	 * @param fileObj the file obj
	 * @param aClass the a class
	 * @return the object
	 * @throws JAXBException the JAXB exception
	 */
	public static Object convertXmlFileToJaxbObject(final File fileObj,
			final Class<?> aClass) throws JAXBException {
		final StreamSource streamSource = new StreamSource(fileObj);
		return getJaxbObject(streamSource, aClass);
	}
	
	/**
	 * Gets the jaxb object.
	 *
	 * @param streamSource the stream source
	 * @param aClass the a class
	 * @return the jaxb object
	 * @throws JAXBException the JAXB exception
	 */
	private static Object getJaxbObject(final StreamSource streamSource,
			final Class<?> aClass) throws JAXBException {
		final JAXBContext jaxbCtx = JAXBContext.newInstance(aClass);
		final Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
		final JAXBElement<?> jaxbElem = unmarshaller.unmarshal(streamSource,aClass);
		return jaxbElem.getValue();
	}
}
