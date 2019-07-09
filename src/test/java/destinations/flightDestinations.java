package destinations;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import appPages.HomepageTest;
import pageObjects.flightPageObjects;
import resource.base;

public class flightDestinations extends base {

	
	
	private static Logger log=LogManager.getLogger(HomepageTest.class.getName());

	@Test
	public void flightPageNavigation() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("flightsPageUrl"));
		flightPageObjects fp=new flightPageObjects(driver);
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		log.fatal("this is a sample fatal msg");
}
}