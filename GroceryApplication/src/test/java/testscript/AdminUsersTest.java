package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserspage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base 
{

	@Test
	public void verifyUserCanCreateAdminUsers() throws IOException // valid Username and Password
	{

		// String username= "admin"; // Valid Username and Valid Password
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
        AdminUserspage adminpage = new AdminUserspage(driver);
		adminpage.clickAdminMoreInfo();
		adminpage.clickAdminNewTab();

		// username password for Staff
		String usernames1 = ExcelUtility.readStringData(1, 0, "AdminUserPage"); 
		String passwords1 = ExcelUtility.readStringData(1, 1, "AdminUserPage");
		adminpage.userTab(usernames1);
		adminpage.passwordTab(passwords1);
		adminpage.selectUserType("staff");
		adminpage.clicksaveButton();
		boolean alertMessage1 = adminpage.alertDisplay();
		Assert.assertTrue(alertMessage1);

		// username and password for Admin

		adminpage.clickAdminNewTab();
		String usernames2 = ExcelUtility.readStringData(2, 0, "AdminUserPage");
		String passwords2 = ExcelUtility.readStringData(2, 1, "AdminUserPage");
		adminpage.userTab(usernames2);
		adminpage.passwordTab(passwords2);
		adminpage.selectUserType("admin");
		adminpage.clicksaveButton();
		boolean alertMessage2 = adminpage.alertDisplay();
		Assert.assertTrue(alertMessage2);

		// username and password for Partner
		adminpage.clickAdminNewTab();
		String usernames3 = ExcelUtility.readStringData(3, 0, "AdminUserPage");
		String passwords3 = ExcelUtility.readStringData(3, 1, "AdminUserPage");
		adminpage.userTab(usernames3);
		adminpage.passwordTab(passwords3);
		adminpage.selectUserType("partner");
		adminpage.clicksaveButton();
		boolean alertMessage3 = adminpage.alertDisplay();
		Assert.assertTrue(alertMessage3);

		// username and password for Delivery Boy
		adminpage.clickAdminNewTab();
		String usernames4 = ExcelUtility.readStringData(4, 0, "AdminUserPage"); // reading from excel file
		String passwords4 = ExcelUtility.readStringData(4, 1, "AdminUserPage");
		adminpage.userTab(usernames4);
		adminpage.passwordTab(passwords4);
		adminpage.selectUserType("db");
		adminpage.clicksaveButton();
		boolean alertMessage4 = adminpage.alertDisplay();
		Assert.assertTrue(alertMessage4);
	}

}
