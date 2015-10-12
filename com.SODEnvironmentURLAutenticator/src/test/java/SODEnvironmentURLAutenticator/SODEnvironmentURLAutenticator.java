package SODEnvironmentURLAutenticator;

import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SODEnvironmentURLAutenticator 
{

	static WebDriver driver;
	static String browser = "firefox";

	@Test
	public static void authenticator() throws Exception 
	{
		if (browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "M:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		} else if (browser.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", "M:\\SeleniumDrivers\\iedriver_win64\\IEDriverServer.exe");
		}

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

		System.out.println("Before Opening the URL");		
		try
		{
			driver.get("http://qa.schoolofdragons.com");	
		}
		catch(Exception e)
		{
			
		}		
		System.out.println("After Opening the URL");
		
		System.out.println("Wait for 30 seconds");
		Thread.sleep(30000);
		System.out.println("After 30 seconds");		
		
		System.out.println("Before Running the exe file");		
		try {
			Runtime.getRuntime().exec("M:\\Autoit Scripts\\MozillaAuthenticationScript.exe");
		} catch (Exception e) {
			System.out.println("Error with the file");
			e.printStackTrace();
		}		
		System.out.println("After Running the exe file");
		
		System.out.println("Wait for 30 seconds");
		Thread.sleep(30000);
		System.out.println("After 30 seconds");		
		
		System.out.println("Before Taking Screenshot");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("D:\\workspace\\com.SODEnvironmentURLAutenticator\\Screenshots\\screenshot"+System.currentTimeMillis()+".png"));
		System.out.println("After Taking Screenshot");	
		
		System.out.println(System.getProperty("user.name"));
		
		System.out.println("Current URL IS : "+driver.getCurrentUrl());
		
		System.out.println("Before finding the element");
		driver.findElement(By.id("nav-mobile"));		
		System.out.println("After finding the element");		
		
		System.out.println("Before Quiting the driver");
		driver.quit();
		System.out.println("After Quiting the driver");
	}
}
