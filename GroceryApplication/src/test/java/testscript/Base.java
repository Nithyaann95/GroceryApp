package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base

{
	public WebDriver driver;

	@BeforeMethod
	public void browserinitalization() 
	{
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin"); // opens the given URL
		driver.manage().window().maximize(); // maximize the browser window

	}
//@AfterMethod

	public void browserQuit() 
	{
		// driver.close(); //close the current browser window
		driver.quit(); // close all browser windows
	}
}
