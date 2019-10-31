package com.hmh.automation.pages;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hmh.automation.tools.ConstantsHMH;

public class TempClass {
	
	
	@Test
	public void tc001(){
		verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH,  "title", "level1test 1 sb060816ISTBVYT1");
		//loopingNodes(ConstantsHMH.DOWNLOADS_PATH);
	}
	
	private boolean getChildNode(NodeList nodeList, String nodeName, String expValue) {
		boolean isNodeFound = false;
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().equalsIgnoreCase(nodeName)) {
				isNodeFound=true;
				System.out.println(tempNode.getTextContent());
				Assert.assertTrue("The Node value is incorect diplaying as: "+tempNode.getTextContent(), tempNode.getTextContent().contains(expValue));
				break;
				}
			if (tempNode.hasChildNodes() && isNodeFound==false) {
					getChildNode(tempNode.getChildNodes(), nodeName, expValue);
				}

			}
		return isNodeFound;
	
	}
	
	public void parseXMLForTest(String loc){
		
		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";

		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyNodeNameAndValue(String loc, String nodeName, String expValue){
		
		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		boolean isFound=false;
		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));			
			if (doc.hasChildNodes()) {
				getChildNode(doc.getChildNodes(), nodeName, expValue);
				isFound=true;
			}
			
			Assert.assertTrue("The node "+nodeName+" is not found in Manifest", isFound);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void verifyNodeShouldNotContainValue(String loc, String nodeName, String ccoName){

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		System.out.println("xml located at "+loc);

		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));
			NodeList nodeList=doc.getChildNodes();
			for (int count = 0; count < nodeList.getLength(); count++) {
				Node tempNode = nodeList.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().contains(nodeName)) {
					System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
					//	System.out.println("Node Value =" + tempNode.getTextContent());
					Assert.assertFalse("The Node contains CCO name which should present in"+tempNode.getTextContent(), tempNode.getTextContent().contains(ccoName));
//					if (tempNode.hasAttributes()) {
//						NamedNodeMap nodeMap = tempNode.getAttributes();
//						for (int i = 0; i < nodeMap.getLength(); i++) {
//							Node node = nodeMap.item(i);
//							System.out.println("attr name : " + node.getNodeName());
//							System.out.println("attr value : " + node.getNodeValue());
//						}
//					}
					System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
			
	public static void verifyXMLattribute(String loc, String attName, String expValue){

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		System.out.println("xml located at "+loc);

		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));
			NodeList nodeList=doc.getChildNodes();
			for (int count = 0; count < nodeList.getLength(); count++) {
				Node tempNode = nodeList.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().contains(attName)) {
					System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
					//	System.out.println("Node Value =" + tempNode.getTextContent());
					Assert.assertTrue("The Node value is incorect diplaying as: "+tempNode.getTextContent(), tempNode.getTextContent().contains(expValue));
					if (tempNode.hasAttributes()) {
						NamedNodeMap nodeMap = tempNode.getAttributes();
						for (int i = 0; i < nodeMap.getLength(); i++) {
							Node node = nodeMap.item(i);
							System.out.println("attr name : " + node.getNodeName());
							System.out.println("attr value : " + node.getNodeValue());
						}
					}
					System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
			
			public void loopingNodes(String loc) {
				
				String actualPath= System.getProperty("user.dir");
				loc=actualPath+loc+"commonCartridgeManifest";
				
				try {
					File file = new File(loc);
					DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
					Document doc = dBuilder.parse(file);
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					if (doc.hasChildNodes()) {
						getChildNodes(doc.getChildNodes());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		
			}
		
		private static void getChildNodes(NodeList nodeList) {
			for (int count = 0; count < nodeList.getLength(); count++) {
				Node tempNode = nodeList.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
					System.out.println("Node Value =" + tempNode.getTextContent());
					if (tempNode.hasAttributes()) {
						NamedNodeMap nodeMap = tempNode.getAttributes();
						for (int i = 0; i < nodeMap.getLength(); i++) {
							Node node = nodeMap.item(i);
							System.out.println("attr name : " + node.getNodeName());
							System.out.println("attr value : " + node.getNodeValue());
						}
					}
					if (tempNode.hasChildNodes()) {
						getChildNodes(tempNode.getChildNodes());
					}
					System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
				}
		
			}
		
		}
		

}
