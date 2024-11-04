package restapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Request {

	int id;

	@Test
	public void get() {

		given().pathParam("path", "users").queryParam("page", 2)
		          .contentType(ContentType.JSON)

				.when().get("https://reqres.in/api/{path}")

				.then().statusCode(200).log().body().header("Content-Type", "application/json; charset=utf-8").and()
				.header("Content-Encoding", "gzip").body("data[0].id", equalTo(7))
				.body("data[0].email", equalTo("michael.lawson@reqres.in")).body("page", equalTo(2))
				.body("data[1].first_name", equalTo("Lindsay")).body("total_pages", equalTo(2))
				.body("support.url", equalTo("https://reqres.in/#support-heading"));

	}

	@Test
	public void getHeaders() {

		Response res = given().queryParam("page", 2).pathParams("mypath", "users")

				.when().get("https://reqres.in/api/{mypath}");
		
		System.out.println(res.getTime());
		System.out.println(res.getTimeIn(TimeUnit.SECONDS));

		io.restassured.http.Headers header = res.getHeaders();

		for (Header all : header) {

			System.out.println("Key: " + all.getName() + " " + "value :" + all.getValue());

		    
		}

	}

	@Test

	public void createUser() {

		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");

		id = given().pathParam("path", "users").body(data)

				.when().post("https://reqres.in/api/{path}").jsonPath().getInt("id");

	}

	@Test

	public void updateUser() {

		HashMap data = new HashMap();
		data.put("job", "zion resident");

		given().pathParam("path", "users").body(data)

				.when().put("https://reqres.in/api/{path}/" + id)

				.then().statusCode(200).log().body().header("Content-type", "application/json; charset=utf-8").and()
				.header("Content-Length", "40").and().header("Server", "cloudflare");

	}

	@Test
	public void deleteUser() {

		given()

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().body();

	}

}
