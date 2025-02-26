package TestScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpRequest;
import org.testng.annotations.Test;

import TestConfig.BaseTest;

public class BrokenLinkTest extends BaseTest {
	
	@Test(enabled=false)
	public void checkBrokenLinks() throws IOException
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List <WebElement> links=driver.findElements(By.tagName("a"));
		List<String>urls=links.stream().map(s->s.getAttribute("href")).collect(Collectors.toList());
		for(String url:urls)
		{
			if(url!=null && !url.isEmpty() )
			{
				if(checkStatusofURL(url)) {
					System.out.println("No Broken Links");
				}
				else
				{
					System.out.println("Broken link"+ url);
				}
			}else
			{
				System.out.println("Broken link"+ url);
			}
			
		}
	}

	private boolean checkStatusofURL(String url) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		HttpURLConnection connect= (HttpURLConnection)new URL(url).openConnection();
		connect.setRequestMethod("HEAD");
		connect.connect();
		int response=connect.getResponseCode();
		if (response==200)
		{
		return true;
				}
		return false;
	}

	@Test
	public void checkActions()
	{
		driver.get("https://www.flipkart.com/");
		WebElement ele=driver.findElement(By.xpath("//input[@name='q']"));
		Actions action=new Actions(driver);
		action.moveToElement(ele).click().keyDown(Keys.SHIFT).sendKeys("Iphone").build().perform();
		action.moveToElement(driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']/../following-sibling::ul//div[contains(text(),'iphone 16 pro')]"))).doubleClick().build().perform();
	}
}
