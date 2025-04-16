package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SuperHelper;

public class LoginPage extends SuperHelper {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='commonModal__close']")
	WebElement close;
	
	@FindBy(xpath = "//span[@class='commonModal__close']")
	WebElement username;
	
	@FindBy(xpath = "//span[@class='commonModal__close']")
	WebElement password;
	
	public void closeSignIn() {
		close.click();
	}

}
