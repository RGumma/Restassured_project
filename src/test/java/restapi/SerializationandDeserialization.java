package restapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SerializationandDeserialization {

	@Test
	public void convertPojotojson() {       //pojo- java object serialization is pojo to json 
		
		Student stupojo = new Student(); // created java object using pojo class
		
		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("123456");
		 
		
		
		
	}
	
	
	
	
}
