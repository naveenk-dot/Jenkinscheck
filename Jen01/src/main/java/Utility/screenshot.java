package Utility;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class screenshot {
	
	 WebDriver driver;
	
	public screenshot(WebDriver driver)
	{
		this.driver=driver;
	}

	public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(sourceFile, Destinationfile);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
}
