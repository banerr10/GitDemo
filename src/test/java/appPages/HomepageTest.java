package appPages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;

import resource.base;

public class HomepageTest extends base{
	private static Logger log=LogManager.getLogger(HomepageTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.debug("browser initialized");
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("homepageUrl"));
		HomePageObjects hp=new HomePageObjects(driver);
		hp.getlogin().click();
		//inheriting method of homepage pageobject class by creating object of the class
	hp.username().sendKeys("I am new user");
	hp.password().sendKeys("this is my password");
	hp.createnewaccount().click();
	hp.emailOrPhone().sendKeys(username);
	hp.createpassword().sendKeys(password);
	System.out.println(text);
	System.out.println("modified for git example");
	String currentpageid=hp.pageHandleId();
	System.out.println("page id of homepage is: "+currentpageid);
	Assert.assertTrue(hp.getNavigationBar().isDisplayed());//to check if the navigation bar is diplayed on the page
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];//rows for how many data types should run and column for how many values per each test
	data[0][0]="nonRestrictedUser@gmail.com";
	data[0][1]="abcde";
	data[0][2]="Restricted user";
	
	data[1][0]="restrictedUser@gmail.com"	;
	data[1][1]="abcde";
	data[1][2]="nonrestricted user";
		return data;	
	}
	@AfterTest
	public void closeBrowser() {
	driver.quit();
	}
}
