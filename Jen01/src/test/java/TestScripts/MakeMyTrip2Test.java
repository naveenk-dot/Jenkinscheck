package TestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestConfig.BaseTest;

public class MakeMyTrip2Test extends BaseTest {

	@Test
	public void searcHubliFlight()
	{
		LoginPage page=new LoginPage(driver);
		page.closeSignIn();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Hubli");
	}
}
