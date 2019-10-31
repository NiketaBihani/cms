package com.hmh.automation.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.fluentlenium.core.Alert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHStandardsHierarchyPage extends AbstractPage {

	public HMHStandardsHierarchyPage(WebDriver driver) {
		super(driver);
	}

	private static final Logger LOG = LoggerFactory
			.getLogger(HMHStandardsHierarchyPage.class);

	@FindBy(css="tbody[id$='STD_GRD_ITEMS'] td span")
	private List<WebElement> gradesList;

	@FindBy(id="uniqName_1_7_label")
	private WebElement saveStructure;

	@FindBy(css="table[id$='APPROVE_STD_CONTROL'] tbody tr td:nth-child(2) input")
	private WebElement statusListArrow;

	@FindBy(css="table[id$='APPROVE_STD_CONTROL_menu'] tbody tr:nth-child(3) td:nth-child(2)")
	private WebElement statusDev;
	
	@FindBy(css="table[id$='APPROVE_STD_CONTROL_menu'] tbody tr:nth-child(2) td:nth-child(2)")
	private WebElement statusPlanning;
	
	@FindBy(css="table[id='APPROVE_STD_CONTROL_menu'] tbody tr td:nth-child(2) ")
	private List<WebElement> statusList; 

	@FindBy(id="uniqName_1_8_label")
	private WebElement approve;

	@FindBy(css="div[id$='STD_STATUS_HORIZONTAL'] div div:nth-child(2) span.alfresco-html-Label")
	private WebElement statusOfStandard;

	@FindBy (xpath="//tbody[@id='STD_GRD_ITEMS']//span[@id='stdTitle']")
	private List<WebElement> standardsList;

	@FindBy (xpath="//tbody[@id='STD_GRD_ITEMS']//span[@id='stdTitle']/preceding::span[3]")
	private List<WebElement> expandButtonList;

	@FindBy(css="span.dijitTreeLabel span[id*='stdTitle']")
	private List<WebElement> sourceStandards;

	@FindBy (css="span[class*='dijitTreeContentExpanded'] span.dijitTreeLabel")
	private List<WebElement> gradeNameAfterExpansionCss;

	String gradeNameCss="span[class$='value']:nth-child(2)";
	String expandGradeButtonXpath = "//tbody[@id='STD_GRD_ITEMS']//td//span[2]/span/span[contains(text(),'gradename')]/preceding::span[2]/img";
	String gradeName="//tbody[@id='STD_GRD_ITEMS']//td//span[2]/span/span[contains(text(),'gradename')]";
	String gradeNameAfterExpansion= "//tbody[@id='STD_GRD_ITEMS']//td//div[2]//span[contains(text(),'gradename')]";
	String gradeNameFolderAfterExpansion= "//tbody[@id='STD_GRD_ITEMS']//div[@class='dijitTreeContainer']//span[contains(text(),'gradename')]/preceding::span[1]";
	String standardName = "//tbody[@id='STD_GRD_ITEMS']//span[contains(text(),'stdName')]";
	String standardNameFolderIcon="//tbody[@id='STD_GRD_ITEMS']//span[contains(text(),'stdName')]/preceding::span[1]";
	String expandStdFolder = "//tbody[@id='STD_GRD_ITEMS']//span[@id='stdTitle'][contains(text(),'stdName')]/preceding::span[3]";

	Actions action = new Actions(getDriver());

	public void verifyStatusOfStandard(String currentStatus){
		boolean isMatched = false;
		waitForElement("div[id$='STD_STATUS_HORIZONTAL'] div div:nth-child(2) span.alfresco-html-Label", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(statusOfStandard).waitUntilVisible();
		System.out.println(statusOfStandard.getText());
		if(statusOfStandard.getText().toLowerCase().contains(currentStatus.toLowerCase())){
			isMatched=true;
		}
		Assert.assertTrue("The current status of Standard is INCORRECT ", isMatched);
	}
	public void changeStatusOfStandard(String status){
		boolean isMatched = false;
		waitForElement("table[id$='APPROVE_STD_CONTROL'] tbody tr td:nth-child(2) input", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(statusListArrow).waitUntilVisible();
		statusListArrow.click();
		for(WebElement currStatus:statusList){
			System.out.println(currStatus.getText());
			if(currStatus.getText().toLowerCase().contains(status.toLowerCase())){
				
				if (status.contains("Development")){
					statusDev.click();	
					isMatched=true;
					
				}
				else if (status.contains("Planning")){
					statusPlanning.click();
					isMatched=true;
					
				}
			
			
		Assert.assertTrue("The current status of Standard is INCORRECT ", isMatched);
			}
			}	
	}
	

	
	public void expandTheGradeStandards(String grade){
		String expandGradeButtonX=expandGradeButtonXpath.replace("gradename", grade);
		waitForElementX(expandGradeButtonX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		getDriver().findElement(By.xpath(expandGradeButtonX)).click();
		waitABit(5000);
		waitForAngularRequestsToFinish();
	}

	public void expandStandardFolder(String stdFolderName){
		String expandStdFolderX=expandStdFolder.replace("stdName", stdFolderName);
		waitForElementX(expandStdFolderX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		getDriver().findElement(By.xpath(expandStdFolderX)).click();
		waitABit(5000);
		waitForAngularRequestsToFinish();    	
	}

	public void clickOnStandard(String standard){
		String stdNameX=standardName.replace("stdName", standard);
		waitForElementX(stdNameX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		getDriver().findElement(By.xpath(stdNameX)).click();
		waitForAngularRequestsToFinish();    	
	}

	public Object executeScript(String s, Object... args) {
		return ((JavascriptExecutor) getDriver()).executeScript(s, args);
	}



	String standardsOfGrade="//span[contains(text(),'grade No')]/following::span[@id='stdTitle']";
	
	public void dragAndDropStandardAtGradeLevel(String sourceGrade, String sourceStandard, String targetGrade){

		boolean isStandardFound= false;
		WebElement elementFrom=null;
		WebElement expand=getDriver().findElement(By.xpath(".//*[@id='EXP_BTN_label']"));
		expand.click();
		waitABit(2000);
		WebElement source=getDriver().findElement(By.xpath(".//*/span[text()='"+sourceGrade+"']"));
		WebElement dest=getDriver().findElement(By.xpath(".//*/span[text()='"+targetGrade+"']/../.."));
		
		Actions builder= new Actions(this.getDriver());
		
		builder.dragAndDrop(source, dest).perform();
		
	//	expandTheGradeStandards(sourceGrade);
		/*for(WebElement sourceStandardIn:sourceStandards){
			if(sourceStandardIn.getText().contains(sourceStandard)){
				isStandardFound=true;
				elementFrom=sourceStandardIn;
				System.out.println(elementFrom);
				break;
			}
		}
		Assert.assertTrue("the Source Standard is not found", isStandardFound);
		//    	String targetStandardName="";
*/		//    	expandTheGradeStandards(targetGrade);
		//    	final List<WebElement> targetStandards= getDriver().findElements(By.xpath(standardsOfGrade.replace("grade No", targetGrade)));
		//    	for(WebElement targetStandard:targetStandards){
		//    		if(targetStandard.isDisplayed()){
		//    			targetStandardName=targetStandard.getText();
		//    			break;
		//    		}
		//    	}
		/*expandTheGradeStandards(targetGrade);
		final WebElement sourceLocation = getDriver().findElement(By.xpath(standardNameFolderIcon.replace("stdName", sourceStandard)));
		System.out.println(standardNameFolderIcon.replace("stdName", sourceStandard));
		
		final WebElement targetLocation = getDriver().findElement(By.xpath(gradeNameFolderAfterExpansion.replace("gradename", targetGrade)));
		System.out.println(gradeNameFolderAfterExpansion.replace("gradename", targetGrade));
		
//		JavascriptExecutor js =(JavascriptExecutor)getDriver();
*///		js.executeScript("arguments[0].style.border='3px dotted blue'", sourceLocation);
//		js.executeScript("arguments[0].style.border='3px dotted blue'", targetLocation);
//		
//		action.dragAndDrop(sourceLocation, targetLocation).perform();
//		
//		Action dragAndDrop =action.clickAndHold(sourceLocation).moveToElement(targetLocation)
//	    .release(targetLocation).build();
//		dragAndDrop.perform();
		
		
//		for(WebElement targetGradeExpanded:gradeNameAfterExpansionCss){
//		if(targetGradeExpanded.getText().contains(targetGrade)){
//			isStandardFound=true;
//			elementTo=targetGradeExpanded;
//			System.out.println(elementTo);
//			break;
//		}
//	}
//
//	final WebElement sourceLocationCSS = elementFrom;
//	final WebElement targetLocationCSS = elementTo;
	//	action.dragAndDrop(sourceLocation, targetLocation).build().perform();
	//	action.moveToElement(sourceLocationCSS).moveToElement(sourceLocationCSS).build();
		
//
//		//   	   final String JS_DRAG_AND_DROP =
//		//   		  "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEff" +
//		//   		  "ect:'',effectAllowed:'all',files:[],items:{},types:[],setData:f" +
//		//   		  "unction(format,data){this.items[format]=data;this.types.append(" +
//		//   		  "format);},getData:function(format){return this.items[format];}," +
//		//   		  "clearData:function(format){}};var emit=function(event,target){v" +
//		//   		  "ar evt=document.createEvent('Event');evt.initEvent(event,true,f" +
//		//   		  "alse);evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);}" +
//		//   		  ";emit('dragstart',src);emit('dragenter',tgt);emit('dragover',tg" +
//		//   		  "t);emit('drop',tgt);emit('dragend',src);";
//		//   	   
//		//   	   js.executeScript(JS_DRAG_AND_DROP, new Object[]{sourceLocationCSS, targetLocationCSS});
//
//		String js_filepath = ConstantsHMH.SCRIPT_HELPER;
//		String java_script="";
//		String text;
//		BufferedReader input = null;
//
//		try {
//			input = new BufferedReader(new FileReader(js_filepath));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		StringBuffer buffer = new StringBuffer();
//
//		try {
//			while ((text = input.readLine()) != null)
//				buffer.append(text + " ");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		java_script = buffer.toString();
//
//		try {
//			input.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String source =standardName.replace("stdName", sourceStandard);
//		String target = gradeNameAfterExpansion.replace("gradename", targetGrade);
//		java_script = java_script+"$('#"+source+"').simulate( '#" +target+ "');" ;
//		((JavascriptExecutor)getDriver()).executeScript(java_script);
//
//
//		//   	 	String javascript ="var dropTarget = jQuery(" + targetLocation + ");" +"\n" +
//		//   	        "jQuery("+ sourceLocation + ").simulate('drag', { dropTarget: dropTarget });";
//		//   	 	js.executeScript(javascript);
//		//   	 	LOG.info("Java script is executed"+javascript);
//		//    	action.clickAndHold(sourceLocation).moveByOffset(2, 2);
//		//    	waitABit(5000);
//		//    	action.moveToElement(targetLocation).perform();
//		//    	waitABit(2000);
//		//    	action.release(targetLocation).build().perform();
//
//		// js = js + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
//
//		//		dragAndDrop.perform();
//
		    /*	Point coordinates1 = sourceLocation.getLocation();
		    	System.out.println(coordinates1);
		    	Point coordinates2 = targetLocation.getLocation();
		    	System.out.println(coordinates2);
		    	Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e) {
					LOG.error("mouse move error", e);
				}
		    	 
		    	robot.mouseMove(coordinates1.getX(), coordinates1.getY());
		    	robot.mousePress(InputEvent.BUTTON1_MASK);
		    	robot.mouseMove(coordinates2.getX(), coordinates2.getY());
		    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    	waitABit(1000);
//		//    	
*/	}

	public void saveStructure(){

		element(saveStructure).waitUntilVisible();
		saveStructure.click();
		/*Alert alert=new Alert(getDriver());
		alert.accept();*/
		refreshPage();

	}
	
	public void clickOnApprove(){
		waitForElementX("//*[text()='APPROVE']",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS , getDriver());
		approve.click();
		Alert alert=new Alert(getDriver());
		alert.accept();
		refreshPage();
	}

	public void verifyTheChangesAreReflected(String sourceGrade, String sourceStandard, String targetGrade){

		waitForElementX(".//*/span[text()='"+targetGrade+"']//following::span[text()='"+sourceGrade+"']",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS , getDriver());
		LOG.info("verified changes");
		/*boolean isStandardFound= false;
		expandTheGradeStandards(sourceGrade);
		final List<WebElement> sourceStandards= getDriver().findElements(By.xpath(standardsOfGrade.replace("grade No", sourceGrade)));
		for(WebElement sourceStandardIn:sourceStandards){
			if(sourceStandardIn.getText().contains(sourceStandard)){
				isStandardFound=true;
				break;
			}
		}
		Assert.assertFalse("The standard is still present after moving to other location", isStandardFound);

		expandTheGradeStandards(targetGrade);
		boolean isMovedStandardFound =false;
		final List<WebElement> targetStandards= getDriver().findElements(By.xpath(standardsOfGrade.replace("grade No", targetGrade)));
		for(WebElement targetStandardIn:targetStandards){
			if(targetStandardIn.getText().contains(sourceStandard)){
				isMovedStandardFound=true;
				break;
			}
		}
		Assert.assertTrue("The moved standard is NOT found in target location", isMovedStandardFound);*/

	}

	public void testDragAndDrop(String sourceGrade, String sourceStandard, String targetGrade) throws IOException{ 
		
			String basePath = new File("").getAbsolutePath();

			final String JQUERY_LOAD_SCRIPT = (basePath + "/src/test/resources/jquery_load_helper.js");
			String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);				    
			getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeAsyncScript(
					jQueryLoader /* , http://localhost:8080/jquery-1.7.2.js */);

			// ready to rock
			js.executeScript("jQuery(function($) { " + " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); "
					+ " }); ");

			//http://stackoverflow.com/questions/29381233/how-to-simulate-html5-drag-and-drop-in-selenium-webdriver
			//"where jquery_load_helper.js contains:"  
			String filePath = basePath + "/src/test/resources/drag_and_drop_helper.js";


			//JQuery can ONLY work with id and css , xpath does NOT work with it.
			String sourceXpath =standardName.replace("stdName", sourceStandard);
			String targetXpath = gradeNameAfterExpansion.replace("gradename", targetGrade);
			String source = "section#wrapper article ul li:nth-child(4) a";
			String target =  "section#wrapper article div"; //#bin";

			StringBuffer buffer = new StringBuffer();
			String line;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while((line = br.readLine())!=null)
				buffer.append(line);

			String javaScript = buffer.toString();
			String XpathConv="document.evaluate";

			javaScript = javaScript + XpathConv + "window.jQuery('" + sourceXpath + "').simulateDragDrop({ dropTarget: '" + targetXpath + "'});";
			((JavascriptExecutor)getDriver()).executeScript(javaScript);

			waitABit(1000);
	
	}

	private static String readFile(String file) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(file);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}


	//<![CDATA[ require(['surf/7799ce4ff4f773cc9eb24bb2cef9b1bb','dojo/domReady!'], function(Page) {  var p = new Page({services:["alfresco\/services\/CrudService", "alfresco\/services\/OptionsService", "show-standards\/widgets\/StandardHierarchyGetCustomService", "alfresco\/dialogs\/AlfDialogService", "alfresco\/services\/DocumentService"],widgets:[{"config": {"widgetMarginRight": "5", "widgets": [{"config": {"title": "Standard Hierarchy", "widgets": [{"id": "QUERY_PARAM", "config": {"value": "guid=E1C6D7C6-DA22-11E2-95B3-3B359DFF4B22", "name": "hidden"}, "name": "alfresco\/forms\/controls\/HiddenValue"}, {"id": "STD_SUB_HORIZONTAL", "config": {"widgets": [{"id": "SBJ_LABEL_LAYOUT", "config": {"widgets": [{"config": {"additionalCssClasses": "bold", "subscriptionTopic": "UPDATE_LABEL", "label": "Look at this!", "subscriptionPayloadProperty": "label"}, "name": "alfresco\/html\/Label"}, {"config": {"publishTopic": "ALF_CREATE_DIALOG_REQUEST", "additionalCssClasses": "bold", "pubSubScope": "", "iconClass": "info-16", "altText": "View Standarad Set Metadata", "publishPayload": {"dialogWidth": "110", "widgetsContent": [{"id": "DOC_ID_LAYOUTP", "config": {"widgets": [{"config": {"label": "Document ID :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOCUMENT_ID", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DOCUMENT_ID", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "documentid"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DOC_VERSION_LAYOUTP", "config": {"widgets": [{"config": {"label": "Version :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOC_VERSION", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DOC_VERSION", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "version"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DOI_LAYOUT", "config": {"widgets": [{"config": {"label": "Date of Import :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DATE_OF_IMPORT", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DATE_OF_IMPORT", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "dataofimport"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DOLM_LAYOUT", "config": {"widgets": [{"config": {"label": "Date of last modified :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOLM", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DOLM", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "datelastmodified"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DSA_LAYOUT", "config": {"widgets": [{"config": {"label": "Date and status of approval :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DSA", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DSA", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "datestatusapproved"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}], "contentHeight": "50", "widgetsButtons": [], "dialogTitle": "View Standard set Metadata", "grade": "", "handleOverflow": "true", "contentWidth": "100", "dialogId": "STD_SET_METADATA"}, "useCurrentItemAsPayload": false}, "name": "alfresco\/renderers\/PublishAction"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "STD_STATUS_HORIZONTAL", "config": {"widgets": [{"config": {"label": "Status :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"config": {"subscriptionTopic": "UPDATE_STATUS", "label": "", "subscriptionPayloadProperty": "label"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "GET_STDDOC", "config": {"itemsProperty": "", "widgets": [{"id": "STD_GRD", "config": {"widgets": [{"config": {"widgets": [{"id": "STD_CELL", "config": {"fieldId": "{index}", "widgets": [{"config": {"publishPayloadType": "PROCESS", "publishGlobal": true, "publishTopic": "ALF_ITEM_SELECTED", "propertyToRender": "grade.0.descr", "config": {"widgets": []}, "publishPayloadModifiers": ["processCurrentItemTokens"], "altText": "Get Standarad Hierarchy", "publishPayload": {"itemAttribute": "guid=E1C6D7C6-DA22-11E2-95B3-3B359DFF4B22", "successMessage": "Showing Standard For Grade {id}", "valueAttribute": "{id}", "url": "hmh\/standards?grade={id}&guid=E1C6D7C6-DA22-11E2-95B3-3B359DFF4B22&type=standard-set-hierarchy&collection=ABDraft"}, "useCurrentItemAsPayload": false}, "name": "alfresco\/renderers\/PublishAction"}, {"id": "GRADE_LINK", "config": {"propertyToRender": "grade.0.descr", "publishTopic": "ALF_CREATE_DIALOG_REQUEST", "publishPayload": {"dialogWidth": "110", "widgetsContent": [{"id": "DOC_ID_LAYOUTP", "config": {"widgets": [{"config": {"label": "Document ID :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOCUMENT_ID", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DOCUMENT_ID", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "documentid"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DOC_VERSION_LAYOUTP", "config": {"widgets": [{"config": {"label": "Version :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOC_VERSION", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DOC_VERSION", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "version"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DOI_LAYOUT", "config": {"widgets": [{"config": {"label": "Date of Import :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DATE_OF_IMPORT", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DATE_OF_IMPORT", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "dataofimport"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DOLM_LAYOUT", "config": {"widgets": [{"config": {"label": "Date of last modified :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOLM", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DOLM", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "datelastmodified"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DSA_LAYOUT", "config": {"widgets": [{"config": {"label": "Date and status of approval :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DSA", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DSA", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "datestatusapproved"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}], "contentHeight": "50", "widgetsButtons": [], "dialogTitle": "View Standard set Metadata", "grade": "{id}", "handleOverflow": "true", "contentWidth": "100", "dialogId": "STD_SET_METADATA"}, "additionalCssClasses": "bold", "useCurrentItemAsPayload": false, "pubSubScope": ""}, "name": "alfresco\/renderers\/PropertyLink"}]}, "name": "alfresco\/documentlibrary\/views\/layouts\/Cell"}]}, "name": "alfresco\/documentlibrary\/views\/layouts\/Row"}], "widgetsForHeader": [], "itemKey": "{index}"}, "name": "alfresco\/documentlibrary\/views\/AlfDocumentListView"}], "loadDataPublishTopic": "STANDARDS_HIERARCHY_DATA"}, "name": "show-standards\/widgets\/AlfList"}, {"config": {"widgets": [], "okButtonLabel": "Save Structure", "cancelButtonLabel": "Doesn't Matter", "showOkButton": true, "okButtonPublishTopic": "SAVE_STRUCTURE_TOPIC", "pubSubScope": "STDDOC_", "showCancelButton": false, "okButtonPublishGlobal": true}, "name": "alfresco\/forms\/Form"}, {"id": "STANDARDS_APPROVE_HORIZONTAL", "config": {"widgets": [{"id": "APPROVE_STD", "config": {"label": "Approve Standard", "requirementConfig": {"initialValue": false}, "fieldId": "APPROVE_STD", "optionsConfig": {"fixed": [{"value": "", "label": "None"}, {"value": "Planning", "label": "Planning"}, {"value": "Development", "label": "Development"}, {"value": "Delivery", "label": "Delivery"}]}, "name": "status"}, "name": "alfresco\/forms\/controls\/DojoSelect"}, {"config": {"widgets": [], "okButtonLabel": "APPROVE", "cancelButtonLabel": "Doesn't Matter", "okButtonPublishTopic": "APPROVE_STDDOC", "showOkButton": true, "showCancelButton": false, "okButtonPublishGlobal": true}, "name": "alfresco\/forms\/Form"}], "widgetWidth": "20"}, "name": "alfresco\/layout\/HorizontalWidgets"}]}, "widthPc": "70", "name": "alfresco\/layout\/ClassicWindow"}, {"config": {"title": "Standard Details", "widgets": [{"config": {"widgets": [{"id": "H_ABGUID", "config": {"value": "", "name": "hidden"}, "name": "alfresco\/forms\/controls\/HiddenValue"}, {"id": "DATE_DISP_LAYOUT", "config": {"widgets": [{"config": {"label": "AB Guid :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "ABGUID", "config": {"subscriptionTopic": "UPDATE_ABGUID", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "guid"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DESC", "config": {"value": "", "label": "Standard Text", "requirementConfig": {"initialValue": false}, "fieldId": "DESC", "name": "descr"}, "name": "alfresco\/forms\/controls\/DojoValidationTextBox"}, {"id": "STD_NUMBER", "config": {"label": "Authority Number", "requirementConfig": {"initialValue": false}, "fieldId": "STD_NUMBER", "name": "number"}, "name": "alfresco\/forms\/controls\/DojoValidationTextBox"}, {"id": "STD_LABEL", "config": {"label": "Standard Label", "requirementConfig": {"initialValue": false}, "fieldId": "STD_LABEL", "name": "label"}, "name": "alfresco\/forms\/controls\/DojoValidationTextBox"}, {"id": "COURSE", "config": {"label": "AB Course Name", "requirementConfig": {"initialValue": false}, "fieldId": "COURSE", "name": "course.descr"}, "name": "alfresco\/forms\/controls\/DojoValidationTextBox"}, {"id": "STANDARDS_MAIN_HORIZONTAL", "config": {"widgets": [{"config": {"label": "Grade:", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "GRADE", "config": {"label": "  ", "subscriptionTopic": "UPDATE_GRADE", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "grade"}, "name": "alfresco\/html\/Label"}], "name": "results.matches.data.grade"}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DATE_DISP_LAYOUT", "config": {"widgets": [{"config": {"label": "Last Modified :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "LAST_MODIFIED", "config": {"subscriptionTopic": "UPDATE_LAST_MODIFIED", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "last_modified"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "VIEW_DETAILS_LINK", "config": {"title": "View full metadata of the standards", "publishTopic": "ALF_CREATE_DIALOG_REQUEST", "additionalCssClasses": "bold", "pubSubScope": "", "label": "View Details", "publishPayload": {"dialogWidth": "710px", "widgetsContent": [{"id": "DATE_DISP_LAYOUT", "config": {"widgets": [{"config": {"label": "AB Guid :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "ABGUID", "config": {"subscriptionTopic": "UPDATE_ABGUID", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "guid"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DESCRIPTION_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "Standard Text :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DESCRIPTIONP", "config": {"label": "  ", "subscriptionTopic": "UPDATE_DESCRIPTION", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "description"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "STANDARD_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "Authority Number :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "STANDARDNUMBERP", "config": {"label": "  ", "subscriptionTopic": "UPDATE_STANDARD_NUMBER", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "standardnumber"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "STANDARD_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "Standard Label :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "STD_LABEL", "config": {"label": "", "subscriptionTopic": "UPDATE_STANDARD_LABEL", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "standardlabel"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "STD_STATUS_HORIZONTAL", "config": {"widgets": [{"config": {"label": "Status :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"config": {"label": "", "subscriptionTopic": "UPDATE_STD_STATUS", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "label"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "STD_VERSION_HORIZONTAL", "config": {"widgets": [{"config": {"label": "AB Version :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"config": {"label": "", "subscriptionTopic": "UPDATE_AB_VERSION", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "version"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DATE_DISP_LAYOUT", "config": {"widgets": [{"config": {"label": "AB Date Modified :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DATE_MODIFIED", "config": {"subscriptionTopic": "UPDATE_DATE_MODIFIED", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "date_modified"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "YEARADOPTED_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "Year Adopted :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "YEARADOPTEDP", "config": {"label": "  ", "subscriptionTopic": "UPDATE_YEAR_ADOPTED", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "yearadopted"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "AUTHORITY_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "Authority Name :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "AUTHORITYP", "config": {"label": "  ", "subscriptionTopic": "UPDATE_AUTHORITY", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "authority"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DATE_DISP_LAYOUT", "config": {"widgets": [{"config": {"label": "Document Title :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "DOCUMENT_TITLEP", "config": {"subscriptionTopic": "UPDATE_DOCUMENT_TITLE", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "document.title"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DATE_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "AB Subject Code :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "AB_SUBJECT_CODEP", "config": {"subscriptionTopic": "UPDATE_AB_SUBJECT_CODE", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "subject.code"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DATE_DISP_LAYOUT", "config": {"widgets": [{"config": {"label": "Subject(Year)  :", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "SUBJECTP", "config": {"subscriptionTopic": "UPDATE_SUBJECT", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "subject_doc.descr"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "DATE_DISP_LAYOUTP", "config": {"widgets": [{"config": {"label": "AB Course Name:", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "COURSEP", "config": {"subscriptionTopic": "UPDATE_COURSE", "label": "  ", "widgetMarginLeft": "5", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "course.descr"}, "name": "alfresco\/html\/Label"}]}, "name": "alfresco\/layout\/HorizontalWidgets"}, {"id": "STANDARDS_MAIN_HORIZONTAL", "config": {"widgets": [{"config": {"label": "Grade:", "additionalCssClasses": "bold"}, "name": "alfresco\/html\/Label"}, {"id": "GRADE", "config": {"label": "  ", "subscriptionTopic": "UPDATE_GRADE", "pubSubScope": "GROUP_USERS_", "subscriptionPayloadProperty": "grade"}, "name": "alfresco\/html\/Label"}], "name": "results.matches.data.grade"}, "name": "alfresco\/layout\/HorizontalWidgets"}], "contentHeight": "1000px", "contentWidth": "700px", "dialogId": "STD_METADATA", "widgetsButtons": [], "dialogTitle": "AB Standards Metadata"}, "useCurrentItemAsPayload": false}, "name": "alfresco\/navigation\/Link"}], "okButtonLabel": "Save", "cancelButtonLabel": "Doesn't Matter", "okButtonPublishTopic": "SAVE_STANDARD", "showOkButton": true, "showCancelButton": false, "okButtonPublishGlobal": true}, "name": "alfresco\/forms\/Form"}]}, "name": "alfresco\/layout\/ClassicWindow"}], "widgetMarginLeft": "5"}, "name": "alfresco\/layout\/HorizontalWidgets"}],publishOnReady:[],webScriptId:"hmhcms/show-standards/show-standard-set-hierarchy.get" }, 'content'); }); //]]></script>


}
