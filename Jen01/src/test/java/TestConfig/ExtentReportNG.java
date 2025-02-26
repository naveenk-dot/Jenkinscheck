package TestConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path= System.getProperty("user.dir")+"//reports//ExtentReport"+timestamp+".html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("ABA Test Automation result");
		reporter.config().setDocumentTitle("TestResults");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
