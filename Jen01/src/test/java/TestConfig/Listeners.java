package TestConfig;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {
	
	

	ExtentTest test; 
	ExtentReports extent=ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	public void onTestStart(ITestResult result) {
		
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		String testCaseName = result.getMethod().getMethodName();
        try {
            getScreenshot(testCaseName);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void onTestFailure(ITestResult result) {
		//screenshot
		extentTest.get().fail(result.getThrowable());
		String testCaseName = result.getMethod().getMethodName();
        try {
            getScreenshot(testCaseName);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
