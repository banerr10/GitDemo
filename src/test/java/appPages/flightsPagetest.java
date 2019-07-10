package appPages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import pageObjects.flightPageObjects;
import resource.base;

public class flightsPagetest extends base{

	private static Logger log=LogManager.getLogger(HomepageTest.class.getName());

	@Test
	public void flightPageNavigation() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("flightsPageUrl"));
	flightPageObjects fp=new flightPageObjects(driver);
		String currentpageid=fp.pageHandleId();
		log.debug("this is sample dubussing msg");
		System.out.println("page id of flight page is: "+currentpageid);
		fp.searchButton().getText();
		log.error("this is sample error");
		log.debug("this is sample dubugging");
Assert.assertEquals(fp.searchButton().getText(), "SEARCH");//verify whther the required text is present in the button of the webpage

	}
	
	@Test
	public void linktextVerifiy() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("flightsPageUrl"));
		flightPageObjects fp=new flightPageObjects(driver);
		driver.findElement(By.linkText("Domestic Flights")).click();
		System.out.println("from gitDemo develop msg");
	}
}
