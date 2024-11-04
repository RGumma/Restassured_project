package restapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

// given()- content type, cookies, add auth, add param,set headers info etc.(Pre - requrests)
	
	// when()- get, post , put , delete  (http requests)
	
	//then()- validate the status code , extract the response , response body, extract headers and cookies

public class HTTPRequests {
	
	int id;
	
	@Test
	public void getUser() {
		
		given()
		.log().headers()
		
		
		.when()
		 .get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
		@Test
	public void createUser() {
			
		HashMap data = new HashMap();  // request body can be created in multiple ways 
		                                   //POJO, HashMAP, Json,gson 
		data.put("name", "rajani");
		data.put("job", "trainer");
		
		
		 id=given()	
		.contentType("application/json")
		.body(data)
		.log().body()
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then()
			//.statusCode(201)
			//.log().all();
			
		}
	@Test	
	public void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "rajitha");
		data.put("job", "pharma");
		
		Response res=given()
			.contentType("application/json")
			.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id);
		
		 System.out.println(res.getHeader("Content-Type"));
		 System.out.println(res.getHeader("Date"));
		 
		Headers header= res.getHeaders();
		
		for( Header h:  header) {
			
			System.out.println("Key "+h.getName()+ " "+"Value :" +h.getValue());
		}
		
	}
		
 //@Test		
 /*public void deleteUser() {
		
	given()
	
	.when()
	.delete("https://reqres.in/api/users/"+id)
	
	.then()
	.statusCode(204)
	.log().all();
 
 
 
 
 
 }*/
		
		
		
		
		
		
	}
		
		
		
	
	
	
	
	



