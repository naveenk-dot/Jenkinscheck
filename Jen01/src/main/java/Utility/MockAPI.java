package Utility;

public class MockAPI {

	
	public static String courseAPI()
	{
		return "{\"dashboard\":{\"purchaseAmount\":910,\"website\":\"rahulshettyacademy.com\"},\"courses\":[{\"title\":\"SeleniumPython\",\"price\":50,\"copies\":6},{\"title\":\"Cypress\",\"price\":40,\"copies\":4},{\"title\":\"RPA\",\"price\":45,\"copies\":10}]}";
	}
	
	
	public static String Booking(String Firstname,String lastname)
	{
		return "{\"firstname\":\""+Firstname+"\",\"lastname\":\""+lastname+"\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";
		}
}
