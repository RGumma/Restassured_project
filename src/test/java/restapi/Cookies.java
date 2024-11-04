package restapi;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

public class Cookies {
	
	
	
	@Test
	public void testCookies() {
		
		
		Response res=given()
		
		.when()
		.get("https://www.google.com");
		//String cookie_value =res.getCookie("AEC"); // get single cookie
		//System.out.println("The value of the cookie" +cookie_value);
		
		Map<String,String>values=res.getCookies();
		Set<String>key=values.keySet();
		for( String k:key ) {
			
			String cookie_value=res.getCookie(k);
			System.out.println("The cookie values are" +cookie_value);
					
		}
		
		
	}

}
