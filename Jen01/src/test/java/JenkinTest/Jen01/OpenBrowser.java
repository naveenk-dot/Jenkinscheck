package JenkinTest.Jen01;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Level;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OpenBrowser {
	
	  @Test
	    public void openBRowser() {
		  WebDriverManager.chromiumdriver().setup();
		  ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless"); // Run browser in headless mode
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
	        options.setCapability("goog:loggingPrefs", logPrefs);
	        WebDriver driver = new ChromeDriver(options);
	        driver.get("https://www.youtube.com/watch?v=iYaTTkpQIbQ&t=1206s");
			driver.get("https://www.youtube.com/watch?v=iYaTTkpQIbQ&t=1206s");
			driver.manage().window().maximize();	
			System.out.println("naveen12345jijij67");
	    }

}


	
