package TestScripts;
import TestConfig.Retry;
import Utility.ExcelUtility;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import TestConfig.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest extends BaseTest {

	@DataProvider(name="JSON")
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//TestData//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1)} };
		}
	
	@DataProvider(name="Excel")
	public Object[][] getExcelData() throws IOException 
	{
		Object[][]data=ExcelUtility.getExcelData("C://Users//Admin//OneDrive//Documents//Demo.xlsx");
		return data;
		
		
		}
	
	@Test(groups="Smoke",dataProvider="JSON",retryAnalyzer=Retry.class)
    public void searchFlightTest(HashMap<String,String> input) {
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","test Failed");
		driver.findElement(By.xpath("//div[@class='searchWidgetContainer']//a[contains(text(),'Search')]")).click(); 
		System.out.println(input.get("password"));
		}
	
	@Test(dependsOnMethods= "OpenWebsiteWithoutLoginTest")
    public void searchHotelTest() {
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","test Failed");
		driver.findElement(By.xpath("//a[contains(@href,'hotels')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		}
	@Test(dataProvider="Excel")
    public void OpenWebsiteWithoutLoginTest(String email, String username, String Password) {
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","test Failed");
		System.out.println(email+" "+ username+ " "+ Password);
        
    }
}


