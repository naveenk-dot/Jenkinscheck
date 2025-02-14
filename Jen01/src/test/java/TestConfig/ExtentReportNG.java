package TestConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()
	{
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("ABA Test Automation result");
		reporter.config().setDocumentTitle("TestResults");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
