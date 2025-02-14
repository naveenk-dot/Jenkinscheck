package TestConfig;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	
	int count=0;
	int maxCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (maxCount<count)
		{
			count++;
			return true;
			
		}
		return false;
	}

}
