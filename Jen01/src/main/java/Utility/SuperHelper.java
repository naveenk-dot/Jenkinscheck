package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.*;

public class SuperHelper {

	WebDriver driver;

	public SuperHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(By findby)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(0));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(findby)));
	}
	

}
