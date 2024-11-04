package restapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {
	
	
												
	public void testBasicAuthentication() {				// basic, Digest and Preemptive uses username and password
		
		
		given()
		
		.auth().basic("postman", "password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
			
		
		.then()
		.statusCode(200)
		.body("authentication", equalTo("True"))
		.log().all();
		
		
		
	}
	
	@Test
	public void testDigestAuthentication() {
		
		given()
		
		.auth().digest("postman", "password")             
		
		.when()
		.get("https://postman-echo.com/basic-auth")
			
		
		.then()
		.statusCode(200)
		.body("authentication", equalTo("True"))
		.log().all();
		
		
	}
	
	@Test
public void testPreemptiveAuthentication() {
		
		given()
		
		.auth().preemptive().basic("postman", "password")             
		
		.when()
		.get("https://postman-echo.com/basic-auth")
			
		
		.then()
		.statusCode(200)
		.body("authentication", equalTo("True"))
		.log().all();
		

}
	
	@Test
	public void testBearerTokenAuthentication() {
		
		String token = "ghp_24pH0IC";
		
		given()
		.headers("Authorization", "Bearer "+token)
		
		.when()
		
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	
		
	}
	
	
	public void testOauth1Authentication() {
		
		given()
		  .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret") // this Oauth1
		
		.when()
		
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

public void testOauth2Authentication() {
		
		given()
		  .auth().oauth2("ghp_24pH0IC") // this Oauth2
		
		.when()
		
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
@Test 
 public void testapikey() {
	 
	 given()
	 .queryParam("appid", "fewyrhewgfydgfeefnjb")  //appid is apikey
	 
	 .when()
	  .get("url")
	 
	 .then()
	 .statusCode(200)
	 .log().all();
	 
 }
}
