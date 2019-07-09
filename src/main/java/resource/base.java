package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class base {

	public static WebDriver driver;
	public static String browser;
	public static String screenshotPath;
	public static String screenshotName;
public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\chausd\\pfizerseleniumDemoProject\\src\\main\\java\\resource\\data.properties");

		prop.load(fis);
		
		if (System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			
			browser=System.getenv("browser");
		}else {
			
			browser=prop.getProperty("browser");
		}
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// execute chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rachana\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			// execute firefox driver
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rachana\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			// execute IE driver
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Rachana\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
	}
public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}


public static void getScreenShot(String result) throws IOException   {
	screenshotName=(result+".jpg");
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://Users//chausd//pfizerseleniumDemoProject//test-output//html//"+screenshotName));


		}






}
