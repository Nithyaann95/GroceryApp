package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;
import utilities.waitUtility;

public class Base

{
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void browserinitalization(String browser) throws Exception 
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin"); // opens the given URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitUtility.IMPLICITWAIT));
		driver.manage().window().maximize(); // maximize the browser window
		
	}

@AfterMethod(alwaysRun=true)

	public void browserQuitAndClose(ITestResult iTestResult) throws IOException 
	{
		if(iTestResult.getStatus()==iTestResult.FAILURE) //iTestResult
		{
			ScreenshotUtility screenshot=new ScreenshotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName());//passing 
		}
		
		driver.quit();
	}
}
