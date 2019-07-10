package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flightPageObjects {
	public WebDriver driver;
	By title= By.xpath("//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]");
	public flightPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public String pageHandleId()
	{
		return driver.getWindowHandle();
		
	}
public WebElement searchButton() {
	return driver.findElement(title);
}
}
	

