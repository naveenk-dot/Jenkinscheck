package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;

public class SuperHelper {

	WebDriver driver;

	public SuperHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(findby)));
	}

	public void SwitchWindow(String toWindowTitle) {

		{
			Set<String> windows = driver.getWindowHandles();
			for (String window1 : windows) {
				driver.switchTo().window(toWindowTitle);
				if(driver.getTitle().contains(toWindowTitle))
				{
					break;
				}
			}
		}

	}
	
	public void SelectByText(WebElement ele, String visibleText )
	{
		Select select =new Select(ele);
		select.selectByVisibleText(visibleText);
	}

}
