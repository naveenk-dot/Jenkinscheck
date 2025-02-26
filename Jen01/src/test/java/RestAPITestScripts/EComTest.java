package RestAPITestScripts;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import POJO.LoginEcommerce;
import POJO.LoginResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class EComTest {

	@Test
	public void loginTest()
	{
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginEcommerce l=new LoginEcommerce();
		l.setUserEmail("naveenkundgol2025@gmail.com");
		l.setUserPassword("Naveen@123");
		RequestSpecification requestLogin=given().spec(req).body(l);
		LoginResponse response=requestLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
		System.out.println(response.getToken());
		System.out.println(response.getMessage());
	}
}
