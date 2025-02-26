package TestScripts;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestConfig.BaseTest;


public class JavaStreamTest extends BaseTest {

	@Test
	public void StringF()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();
		
		String current=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for (String window:windows)
		{
			if (!window.equals(current))
			{
				driver.switchTo().window(window);
			}
		}
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		List <WebElement> vegetables=driver.findElements(By.xpath("//tbody//tr//td[1]"));
		
		List<String> originalList=vegetables.stream().map(s->s.getText()).collect(Collectors.toList());
		List <String>SortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(SortedList));
		
		for (WebElement ele:vegetables)
		{
			if(ele.getText().equals("Beans"))
			{
				String price=ele.findElement(By.xpath("following-sibling::td[1]")).getText();
				System.out.println(price);
			}
		}
	
	}
}