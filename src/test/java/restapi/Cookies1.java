package restapi;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Cookies1 {
	
	
	@Test
	public void getCookies() {
		
		
		Response res=given()
				
				.when()
				.get("https://www.google.com");
				
		
		      Map<String, String>values= res.getCookies();
		      
		           for(Map.Entry<String, String> k: values.entrySet()) {
		            	
		            	System.out.println(k.getKey()+" "+k.getValue());
		            }
		            
		            
		            
		            
		         
		                       
		           
		           
		            
		            
		           
		           
		                      
		      
		
		
		
		
		
		
		
		
		
		
	}

}
