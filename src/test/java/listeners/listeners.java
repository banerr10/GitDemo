package listeners;



import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import resource.base;
import utilities.MonitoringMail;
import utilities.TestConfig;

public class listeners implements ITestListener,ISuiteListener{
base b=new base();
public String messageBody;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			base.getScreenShot(result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Capturing screensot");
		Reporter.log("<a target=\"_blank\" href="+base.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"+base.screenshotName+\"><img src="+base.screenshotName+" height=200 width=200></img></a>");
				
	
	}
	
		

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		MonitoringMail mail= new MonitoringMail();
		//System.out.println(InetAddress.getLocalHost().getHostAddress());
		
		
		
		try {
			messageBody = "http:/"+InetAddress.getLocalHost().getHostAddress()+":8080/job/MavenJob/HTML_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//System.out.println(messageBody);
	try {
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
