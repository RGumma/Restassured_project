package restapi;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class JSON_XMLSchema {
	
	
	
	@Test
public void testJsonSchemaValidation() {
		
		
		given()
		
		
		
		.when()
		  .get("http://localhost:3000/store")
		
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
		
		
		//from XML- XSD converter
	}	
		
	@Test	
	public void xmlSchemaValidation() {
		
		given()
		
		
		
		.when()
		 .get("http://restapi.adequateshop.com/api/Traveler")
		
		
		.then()
		 .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
		
		
	}
		
		
		
		
		
		
		
		
		
	}
	
	

