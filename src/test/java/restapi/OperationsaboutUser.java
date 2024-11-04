package restapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

public class OperationsaboutUser {
	String name = "rajani";
	
	@Test
	public void testUserCreation() {
		
		HashMap data= new HashMap();
		data.put("id", 123);
		data.put("username" ,name);
		data.put("firstName", "vasisht");
		data.put("lastname", "kota");
		data.put("email", "vasishtKota@gmail.com");
		data.put("password", "Krishna");
		data.put("phone", "3098259364");
		data.put("userstatus",1);
		
		given()
		.contentType(io.restassured.http.ContentType.JSON)
		.body(data)
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.statusCode(200);
		
		given()
		.pathParam("username",name)
		.when()
		.get("https://petstore.swagger.io/v2/user/{username}")
		.then()
		.body("username",equalTo("rajani"))
		.log()
		.all();
		
	}
	
	
@Test
	public void updateuser() {
	
	HashMap data= new HashMap();
	data.put("phone", "9290168267");
	
	
	given()
	.pathParam("username",name)
	.contentType("application/json")
	.body(data)
	
	
	.when()
	.put("https://petstore.swagger.io/v2/user/{username}")
	
	.then()
	.statusCode(200)
	.log().all();
	
	
	
	
	
	
}

}
