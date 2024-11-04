package restapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {
	
	
	
	@Test
public void testJsonResponse() {
		
		
		Response res=given()
		.contentType(ContentType.JSON)
		
		
		.when()
		 .get("http://localhost:3000/store");
		
		
		//.then()
		//.statusCode(200)
		//.header("Content-Type", "text/html; charset=ISO-8859-1")
		//.body("book[3].title", equalTo("The Lord of the Rings"));
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json, charset=utf-8");
		
		String bookname= res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname,"The Lord of the Rings");
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean status = false;
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			if(bookTitle.equals("The Lord of the Rings")) {
				
				status = true;
				break;
				
			}
		}
		
		Assert.assertEquals(status, true);
	
		 double totalprice =0;
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			
			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
	      totalprice = totalprice+Double.parseDouble(price);
	
		}

	   System.out.println(totalprice);
	   Assert.assertEquals(totalprice, 53.92);
	   
}
	
	
}
