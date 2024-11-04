package restapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParseXMLResponse {
	
	
	@Test
public void testXmlResponse() {
		
	Response res=given()
	
	.when()
	.get("http://restapi.adequateshop.com/api/Travelers?page=1");
	
	//.then()
	//.statusCode(200)
	//.header("Content-Type", "application/xml; charset=utf-8")
	//.body("TravelerinformationResponse.page", equalTo("1"))
	//.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Vijay Bharath Reddy"));
	
	Assert.assertEquals(res.statusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"),"application/xml; charset=utf-8");
	
	  String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
	  
	  Assert.assertEquals(pageNo, "1");
	  
	  
	  XmlPath xm= new XmlPath(res.asString());
	  
	  List<String>travelers=xm.getList("TravelerinformationResponse.travelers.Travelerinformation");
	  Assert.assertEquals(travelers.size(),10);
	  
	  List<String>travelers_name=xm.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	  boolean flag= false;
	  for(int i=0; i<travelers_name.size(); i++) {
		  
		 String name= travelers_name.get(i);
		 
		 if(name.equals("Vijay Bharath Reddy")) {
			 
			 flag= true;
			 break;                       // response validation-data
			                               // schema validation - type of data
		 }
			 
	 }
	  
	  
	  Assert.assertEquals(flag,true);
	  
	  
	  
	  
	  
	  
	
	
	}

}
