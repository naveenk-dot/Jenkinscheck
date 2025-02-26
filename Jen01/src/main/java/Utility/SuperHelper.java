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

	//Explicit Wait
	public void waitForElement(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(findby)));
	}
	
	//Scroll Page
	public void ScrollPage(int horizontal, int vertical )
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(horizontal,vertical)");
	}
	
	//JavaScript click element
	public void javaScriptClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguements[0].click();", element);
	}
	
	//Scroll the table which is present in Web[age with css selector
	public void scrollTable(WebElement Table ,int horizontal, int vertical)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('"+Table+"').scrollBy(horizontal,vertical)");
	}

	//SwitchWindow
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
