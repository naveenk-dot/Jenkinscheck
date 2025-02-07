package TestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demotest01 {
	WebDriver driver;
	@BeforeMethod
	public void initiateBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	  @Test
	    public void shouldAnswerWithTrue() {
		  driver.get("https://www.youtube.com/watch?v=iYaTTkpQIbQ&t=1206s");
		  driver.manage().window().maximize();
	    }

	  @AfterMethod
	  public void close()
	  {
		  driver.close();
	  }
}

