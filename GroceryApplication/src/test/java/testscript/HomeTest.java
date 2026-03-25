package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base 
{
	public HomePage homepage;
	@Test (description = "This test case verifies that the application allows a user to successfully log in"
			           + " when valid username and password are provided. Upon successful authentication, the user should be redirected to the dashboard page.")
	
	
	public void verifyTheUserisAbleToLoginUsingValidCredentials() throws IOException // valid username and password
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSigninButton();	
		//HomePage logout = new HomePage(driver);
		homepage.clickOnAdminTab();
		loginpage=homepage.clickOnLogOut();
		
		boolean alert = homepage.isSubmitButtonDisplayed(); 
		Assert.assertTrue(alert,Constant.USERISABLETOLOGOUT); 
	}

}
