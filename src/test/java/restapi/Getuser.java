package restapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Getuser {
	
	
	@Test
	public void createUser() {
		
		HashMap m = new HashMap();
		m.put("id", 124);
		m.put("username", "vasisht");
		m.put("firstname", "Mohana");
		 m.put("lastName", "kota");
		 m.put("email", "MohanaKota@gmail.com");
		 m.put("password","chandra");
		 m.put("phone", "3098259364");
		  m.put("userStatu",1);
		
		
		
		given()
		.accept("application/json")
		.contentType("application/json")
		.body(m)
		
		.when()
		.post("https://petstore.swagger.io/v2/user")
		
		
		.then()
		.log().all();
		
	}
	
	
	@Test
	public void getUser() {
		
		String name = "vasisht";
		
	given()
	.pathParam("username", name)
	
	.when()
	.get("https://petstore.swagger.io/v2/user/{username}")
	
	
	.then()
	 .log().all();
	
	
	
	
	}
	
	
	}


