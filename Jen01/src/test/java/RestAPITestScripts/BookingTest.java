package RestAPITestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJO.BookingDates;
import POJO.BookingRequest;
import Utility.ExcelUtility;
import Utility.MockAPI;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class BookingTest {

	@Test(dataProvider="Excel")
	public void createBookingTest(String first,String last)
	{
		given().baseUri("https://restful-booker.herokuapp.com").
		contentType(ContentType.JSON).
		body(MockAPI.Booking(first,last)).
		when().
		post("https://restful-booker.herokuapp.com/booking").
		then().assertThat().statusCode(200).
		body("booking.firstname", equalTo("RAM")).
		body("booking.bookingdates.checkin", equalTo("2018-01-01"));
	}
	
	public void createBookingWithPojoTest()
	{
		BookingRequest BR=new BookingRequest();
		BR.setTotalprice(500);
		BR.setAdditionalneeds("yes");
		BR.setDepositpaid(true);
		BR.setFirstname("Naveen");
		BR.setLastname("KUND");
		BookingDates BD=new BookingDates();
		BD.setCheckin("2018-01-01");
		BD.setCheckout("2019-01-01");
		BR.setBookingdates(BD);
		given().baseUri("https://restful-booker.herokuapp.com").
		contentType(ContentType.JSON).
		body(BR).
		when().
		post("https://restful-booker.herokuapp.com/booking").
		then().assertThat().statusCode(200);
	}
	
	@DataProvider(name="names")
	public Object[][] getdata()
	{
		return new Object[][] {{"RAM","Lakshman"},{"Hubli","Dharwad"}};
	}
	@DataProvider(name="Excel")
	public Object[][] getExcelData() throws IOException 
	{
		Object[][]data=ExcelUtility.getExcelData("C://Users//Admin//OneDrive//Documents//Demo2.xlsx");
		return data;
		
		
		}
}
