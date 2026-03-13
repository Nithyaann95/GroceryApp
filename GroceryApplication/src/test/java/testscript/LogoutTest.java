package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base 
{
	@Test
	public void verifyTheUserisAbleToLoginUsingValidCredentials() throws IOException // valid username and password
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isDashboardDisplayed(); 
		Assert.assertTrue(homepage); 
		LogoutPage logout = new LogoutPage(driver);
		logout.clickOnAdminTab();
		logout.clickOnLogOut();
	}

}
