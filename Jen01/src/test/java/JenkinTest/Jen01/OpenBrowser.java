package JenkinTest.Jen01;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OpenBrowser {
	
	  @Test
	    public void openBRowser() {
		  WebDriverManager.chromiumdriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.youtube.com/watch?v=iYaTTkpQIbQ&t=1206s");
			driver.manage().window().maximize();	
			System.out.println("naveen");
	    }

}


	
