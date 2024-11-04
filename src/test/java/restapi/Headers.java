package restapi;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headers {
												//Authentication and authorization
	@Test(priority=1)						 // basic 
	public void testHeaders() {					//Digest
												//preemptive		
												// bearer token
		
		given()									// oauth
													// api key 
		
		.when()
		.get("https://www.google.com")
		 
		
		.then()
		.statusCode(200)
		.log().all();
		//.header("Content-Type", "text/html; charset=ISO-8859-1")
		//.and()
		//.header("Content-Encoding","gzip")
		//.and()
		//.header("Server", "gws");
		
	}
	
	@Test(priority=2)
	public void getHeaders() {
		
		Response res=given()
		
		
		.when()
		.get("https://www.google.com");
		
		//String header_value=res.getHeader("Content-Encoding");
		//System.out.println("The header value is " +header_value);
		         io.restassured.http.Headers allheaders =res.getHeaders();
		 
		    for(Header hd: allheaders) {
		    	
		    System.out.println("key:"+hd.getName() + "Value:"+hd.getValue());	
		    	
		    }
		
		
		
	}
	

}
