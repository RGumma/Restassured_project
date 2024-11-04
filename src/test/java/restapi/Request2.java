package restapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Request2 {
	
	
	@Test
	public void validateJsonResponse() {
		
		Response res=given()
		.pathParam("mypath", "2")
		
		.when()
		.get("https://reqres.in/api/users/{mypath}");
		
		
		JSONObject jo = new JSONObject(res.asString());
		JSONObject ji = jo.getJSONObject("data");
		System.out.println(ji.get("id"));
		
	
	}
	
	@Test
	public void validateJsonUsers() {
		
		Response res =given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		
		
		.when()
		.get("https://reqres.in/api/{mypath}");
		
		
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0; i<jo.getJSONArray("data").length();i++) {
			
			
			String value = jo.getJSONArray("data").getJSONObject(i).getString("first_name").toString();
			
		   System.out.println(value);
		   
		   if(value.equals("Tobias")) {
			   
			   break;
		   }
		
		
	}
	
}
	
	
	
	

}
