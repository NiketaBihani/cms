package com.hmh.automation.pages;


import static net.serenitybdd.rest.SerenityRest.rest;
//import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import net.thucydides.core.annotations.Step;

import org.openqa.selenium.WebDriver;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class HMHAlfrescoServices extends AbstractPage {


	public HMHAlfrescoServices(WebDriver driver) {
		super(driver);
	}
	private static final long serialVersionUID = 4664934974746143785L;

	ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();


	private String APIUrl="";
	// http://10.34.36.46:8080/share/page/site
	// https://cert.cms.hmhco.com/share/page/site
	//"http://10.34.36.46:8080/alfresco/service/api/";
	public static Response response;
	public static String jsonAsString;

	@Step("For authenticating the Alfresco OneCMS user while login with valid credentials")
	public void alfresco_Login(){

		String userData ="{\"username\":\"automation_user_01\",\"password\":\"welcome\"}";
		rest().given().request().
		contentType("application/json").
		body(userData).
		when().
		post(APIUrl+"login").
		then().
		statusCode(200); //OK request successful

	}

	@Step("Extract ticket ID after successful Login to OneCMS")
	public String login_Ticket(){

		String userData ="{\"username\":\"automation_user_01\",\"password\":\"welcome\"}";

		response = rest().given().request().
				contentType("application/json").
				body(userData).
				when().
				post(APIUrl+"login").
				then().
				statusCode(200).
				extract().response();
		jsonAsString=response.asString();

		JsonPath jsonPath = new JsonPath(jsonAsString);
		String ticketID = jsonPath.getString("ticket");	
		System.out.println(ticketID);
		return ticketID;


	}

	@Step("Validate Login Ticket")
	public void validate_LoginTicket(){

		rest().given().request().
			contentType("application/json").
			auth().basic(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN).
		when().
			get(APIUrl+"login/ticket/"+login_Ticket()).
		then().
			statusCode(200);


	}

	@Step("Delete Site: {0} using Alfresco API")
	public void deleteSite(String siteName){
		String shortName=siteName.toLowerCase();
		URL aURL = null;
		try {
			aURL = new URL( getDriver().getCurrentUrl());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String Url= aURL.getProtocol()+"://"+aURL.getAuthority()+"/alfresco/service/api/";
		String siteNameJSON="{\"shortName\":'"+shortName+"'}";
		System.out.println(Url);
		rest().given().request().
			contentType("application/json").
			auth().basic(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN).
			//body(siteNameJSON).
		when().
			delete(Url+"sites/"+shortName).
		then().
			statusCode(200);

	}















	@Step("Syncing data from iPad to ODMS for BAS user")
	public void sync_Assessment_Data_From_Ipad_To_ODMS() {

		String inputXMLSyncFromIpadToODMS = "<assessment> <email>vjaUJlZyhWRjYjs7+fIgfw==</email> <password>w9PsOAxRJSUd+gWCsET6U7oor4ws30dpW8ZX4pwHV17y1bu2xT9stC66BZrk1k1Y</password> <classes> <class name=\"FyVkc6A+NhlpTQUqazsNqoUhsy4XNu06oq8P0wxxnqQ=\" id=\"QLY5VPHBAOlTwEkkNnBBpg==\"> <grades>Y9LtaVLgHP8MGZ/wB9N+lA==</grades> <startdate>86d5DA6JabZwfYyZFQm6aQ==</startdate> <enddate>+TOuG8wCSak9YYZW3hJafQ==</enddate> <schoolyear>EErQZXXG8NFA9zG3uv7SDA==</schoolyear> <student id=\"WIY0o0q+Vf55vO4BZ7lNiA==\"> <studentid>kCMGn27CGV3xQzywlWffvg==</studentid> <firstname>EVvGZwSRNl3RjjQ9dEUVAA==</firstname> <lastname>blFAYhc/c3C9dNQs/R6AQw==</lastname> <gradeid>Y9LtaVLgHP8MGZ/wB9N+lA==</gradeid> <gender>XsguClg979bIJcKvE0f9dA==</gender> <maxindependentlevel>hDh8jrv4kE5fwfV13iwnFg==</maxindependentlevel> <maxinstructionallevel>TKxTQkM2uhZhfO3g1Ve6lw==</maxinstructionallevel> <placementlevel>TKxTQkM2uhZhfO3g1Ve6lw==</placementlevel> <benchmark name=\"hL05KWfFasmyJ7LyekGxRg==\"> <creationdate>/qJKu9F1wXACYyqNKCx3oA==</creationdate> <book title=\"QpqB4Vf0/gG02BhUKhfQKg==\" id=\"TKxTQkM2uhZhfO3g1Ve6lw==\"> <type>j1xyBuIa35vdePuDhPtZDw==</type> <textlevel>DtNR8P1UDwLlrEhZgTy9BQ==</textlevel> <genre>j1xyBuIa35vdePuDhPtZDw==</genre> <difficultylevel>MFL6mULZA7YdoPFiJ30paQ==</difficultylevel> <accuracy>WVZeMPfRBXF+OluwR3J7Jw==</accuracy> <fluency>N1nM/Y8gxHqOWMa2ULk3QA==</fluency> <selfcorrection>TKxTQkM2uhZhfO3g1Ve6lw==</selfcorrection> <compscore>kKmGgic0OAFK+iPphMxinA==</compscore> <compadditional>TKxTQkM2uhZhfO3g1Ve6lw==</compadditional> <compabout>TKxTQkM2uhZhfO3g1Ve6lw==</compabout> <compbeyond>3RR+67lkfB0m8ddDqQPF9Q==</compbeyond> <compcode>kKmGgic0OAFK+iPphMxinA==</compcode> <compwithin>3RR+67lkfB0m8ddDqQPF9Q==</compwithin> <readingrate>JuBx5dxKnNmv8Sl2bmwFFQ==</readingrate> <writing>3RR+67lkfB0m8ddDqQPF9Q==</writing> <pdf>JVBERi0xLjMKJcTl8uXrp/Og0MTGCjQgMCBvYmoKPDwgL0xlbmd0aCA1IDAgUiAvRmlsdGVyIC9GbGF0ZURlY29kZSA+PgpzdHJlYW0KeAHVm1mPHEdygN/rV+ST0WNwmnVkXYRBQKIkSmtdqxlbD4YhNJtNzVh9UNMzS/AH +WFCnN0YXJ0eHJlZgoxODgzMjIKJSVFT0YK</pdf> </book> </benchmark> </student> </class> </classes> </assessment>";
		String assessmentClassesResponse = "<class schoolyear=\"EErQZXXG8NFA9zG3uv7SDA==\" description=\"5wCQT7mh8W7EFNkIwWI9tsqiTQmHUCY46Jo6WG9bexQ=\" status=\"atj/23LCptcEJcKek9WGtg==\" name=\"FyVkc6A+NhlpTQUqazsNqoUhsy4XNu06oq8P0wxxnqQ=\" id=\"QLY5VPHBAOlTwEkkNnBBpg==\" />";
		String syncFromIpadFullRespnse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Assessment><classes><class schoolyear=\"EErQZXXG8NFA9zG3uv7SDA==\" description=\"5wCQT7mh8W7EFNkIwWI9tsqiTQmHUCY46Jo6WG9bexQ=\" status=\"atj/23LCptcEJcKek9WGtg==\" name=\"FyVkc6A+NhlpTQUqazsNqoUhsy4XNu06oq8P0wxxnqQ=\" id=\"QLY5VPHBAOlTwEkkNnBBpg==\" /></classes></Assessment>";

		final StringWriter writer = new StringWriter();
		//    final PrintStream captor = new PrintStream(new WriterOutputStream(writer), true);

		rest().given().
		request().
		contentType("text/plain; charset=UTF-8").
		body(inputXMLSyncFromIpadToODMS).

		expect().
		response().
		log().body().
		contentType("application/xml").
		body(containsString(assessmentClassesResponse)).
		//		body(equalTo(syncFromIpadFullRespnse)).

		when().
		post(APIUrl+"/ipadencryptrecord/syncportal/assessment").

		then().
		statusCode(200);
	}
}
