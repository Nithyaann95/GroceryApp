package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base

{
	@Test   // valid username and valid password
	public void verifyTheUserisAbleToLoginUsingValidCredentials() throws IOException 
	{
		// String username= "admin"; 
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isDashboardDisplayed(); 
		Assert.assertTrue(homepage);
	}

	@Test   // invalid username and valid password
	public void verifyTheUserisAbleToLoginUsingInvalidusernameandvalidpassword() throws IOException 
																									 
	{
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage);
	}

	@Test   // valid username and invalid password
	public void verifyTheUserisAbleToLoginUsingValidusernameandinvalidPassword() throws IOException 
																																																
	{
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
	}

	@Test   // invalid username and Password
	public void verifyTheUserisAbleToLoginUsingInvalidValidusernameandPassword() throws IOException 
																																																
	{
		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
	}

}
