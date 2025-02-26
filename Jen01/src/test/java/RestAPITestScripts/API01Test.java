package RestAPITestScripts;

import org.testng.annotations.Test;

import Utility.MockAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API01Test {

	// Number of courses returned by API
	@Test
	public void Api_01_Test() {
		// given, when, then

		JsonPath jp = new JsonPath(MockAPI.courseAPI());
		int Noofcourse = jp.getInt("courses.size()");
		System.out.println(Noofcourse);
	}

	// print purchase amount
	@Test
	public void Api_02_Test() {
		// given, when, then

		JsonPath jp = new JsonPath(MockAPI.courseAPI());
		int amount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
	}

	// Print Title of the first course
	@Test
	public void Api_03_Test() {
		// given, when, then

		JsonPath jp = new JsonPath(MockAPI.courseAPI());
		String title = jp.get("courses[0].title");
		System.out.println(title);

	}

	// Print All course titles and their respective Prices
	@Test
	public void Api_04_Test() {
		// given, when, then

		JsonPath jp = new JsonPath(MockAPI.courseAPI());
		int count=jp.getInt("courses.size()");
		
		for (int i=0;i<count;i++)
		{
			String title=jp.get("courses["+i+"].title");
			int price=jp.get("courses["+i+"].price");
			System.out.println(title+" "+price);
		}

	}
}
