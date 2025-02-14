package TestConfig;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void initializeDriver() {
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//Config//config.properties");
			properties.load(fis);

			String browser = properties.getProperty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromiumdriver().setup();
				String downloadDir = System.getProperty("user.dir")+"//Downloads";

		        // Create the directory if it doesn't exist
		        File directory = new File(downloadDir);
		        if (!directory.exists()) {
		            directory.mkdirs();  // Create the directory
		        }
				HashMap<String,Object> prefs= new HashMap<>();
				prefs.put("download.default_directory", downloadDir);
				prefs.put("download.prompt_for_download", false);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get(properties.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	//data reader Json
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap- Jackson Databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

		// {map, map}

	}

	public String getScreenshot(String testCaseName) throws IOException {
		if (driver instanceof TakesScreenshot) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			FileUtils.copyFile(source, new File(destination));
			return destination;
		}
		return null; // Handle the case where driver is not an instance of TakesScreenshot
	}
}
