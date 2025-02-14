package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SuperHelper;

public class HomePage extends SuperHelper {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@title,'Products')]")
	WebElement searchBox;

	@FindBy(xpath = "//div[contains(@class,'_75nlfW')]//div[contains(@class,'KzDlHZ')]")
	List<WebElement> phones;
	
	@FindBy(xpath = "//table[@summary='Provide table summary here'][1]")
	WebElement table;
	
	public void Printname()
	{
		System.out.println("Naveen");
	}

	public void searchProduct(String product, String exact_match) {
		searchBox.sendKeys(product);
		searchBox.submit();
		for (WebElement phone : phones) {

			if (phone.getText().equals(exact_match)) {
				phone.click();
				SwitchWindow("");
			}
		}

	}
	public void readTable(String Description)
	{
	  List <WebElement> rows=driver.findElements(By.xpath("(//table[@summary='Provide table summary here'])[1]//tr"));
	  for (int i=2;i<=rows.size()-1;i++)
	  {
		  WebElement ele=driver.findElement(By.xpath("(//table[@summary='Provide table summary here'])[1]//tr["+i+"]/td"));
		  if(ele.getText().contains(Description))
		  {
			  WebElement ele1=driver.findElement(By.xpath("(//td[contains(text(),'"+Description+"')])[1]/following-sibling::td[1]"));
			  System.out.println(ele.getText());
			  break;
		  }
	  }
	}
}
