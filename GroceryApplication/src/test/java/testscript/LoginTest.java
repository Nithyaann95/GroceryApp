package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base

{
	public HomePage homepage;
	
	@Test (groups="regression",description="This test case verifies that the application allow a user to log in when both the username and password are correct."
			                              +"The system should display an appropriate message or alert indicating successful login.")
	
	public void verifyTheUserisAbleToLoginUsingValidCredentials() throws IOException 
	{
		// String username= "admin"; 
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
	    homepage=loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isDashboardDisplayed(); 
		Assert.assertTrue(homepage,Constant.LOGINWITHVALIDUSERNAMEANDPASSWORD);
	}

	@Test (description="This test case verifies that the application does not allow a user to log in when an incorrect (invalid) username is provided along with a valid password. "
			          + "The system should display an appropriate error message or alert indicating unsuccessful login.")
	
	public void verifyTheUserisAbleToLoginUsingInvalidusernameandvalidpassword() throws IOException 
																									 
	{
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
	    homepage=loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage,Constant.LOGINWITHINVALIDUSERNAME);
	}

	@Test  (description="This test case verifies that the application prevents login when a correct (valid) username is entered with an incorrect (invalid) password."
			          + "The system should display an appropriate error message or alert indicating that authentication has failed.")
	
	public void verifyTheUserisAbleToLoginUsingValidusernameandinvalidPassword() throws IOException 
																																																
	{
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
	    homepage=loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage,Constant.LOGINWITHINVALIDPASSWORD);
	}

	@Test  (description="This test case verifies that the application does not allow a user to log in when both the username and password are incorrect. "
			           +"The system should reject the login attempt and display an appropriate error message or alert indicating invalid credentials.")
	
	public void verifyTheUserisAbleToLoginUsingInvalidusernameandPassword() throws IOException 
																																																
	{
		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
	    homepage=loginpage.clickOnSigninButton();
		boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage,Constant.LOGINWITHINVALIDUSERNAMEANDPASSWORD);
	}

}
