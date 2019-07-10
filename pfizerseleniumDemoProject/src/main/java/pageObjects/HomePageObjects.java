package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;
	By login= By.xpath("//p[contains(text(),'Login or Create Account')]");
	By newaccount= By.xpath("//a[@class='latoBlack']");
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By emailcreation=By.xpath("//input[@id='emailOrPhone']");
	By passwordcreation=By.xpath("//input[@id='password']");
	By createaccountbutton=By.xpath("//button[contains(@class,'capText font16')]");
	By navbar=By.xpath("//ul[@class='makeFlex font12']");
	public HomePageObjects(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	
	
	
	
	public WebElement username()
	{
		return driver.findElement(username);
	
	}
	
	
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	
	
	public WebElement createnewaccount()
	{
		return driver.findElement(newaccount);
	}
	
	
	
	public WebElement emailOrPhone()
	{
		return driver.findElement(emailcreation);
	}
	public WebElement createpassword()
	{
		return driver.findElement(passwordcreation);
	}
	
	
	public WebElement createaccount()
	{
		return driver.findElement(passwordcreation);
	}
	public String pageHandleId()
	{
		return driver.getWindowHandle();
		
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
	}
	
}
