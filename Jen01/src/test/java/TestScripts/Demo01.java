package TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import TestConfig.BaseTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo01 extends BaseTest {

	@Test
    public void OpenWebsiteWithoutLogin() {
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","test Failed");
        
    }
	
	@Test
    public void searchFlight() {
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","test Failed");
		driver.findElement(By.xpath("//div[@class='searchWidgetContainer']//a[contains(text(),'Search')]")).click();    
		}
	
	@Test
    public void searchHotel() {
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		Assert.assertEquals(driver.getTitle(),"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","test Failed");
		driver.findElement(By.xpath("//a[contains(@href,'hotels')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		}
}


