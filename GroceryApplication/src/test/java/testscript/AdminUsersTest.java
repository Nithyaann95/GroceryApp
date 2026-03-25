package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserspage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base 
{
	public HomePage homepage;
	public AdminUserspage adminuserspage;

	@Test(retryAnalyzer=retry.Retry.class,description="This test case verifies that a valid user is able to log in to the application "
			                                        + "and successfully add a new admin user by providing the required details. "
			                                        + "It ensures that the system displays a confirmation alert after saving the admin user information.")
	
	public void verifyUserCanCreateAdminUsers() throws IOException // valid Username and Password
	{
        String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSigninButton();
		
		//String usernames1 = ExcelUtility.readStringData(1, 0, "AdminUserPage"); 
		//String passwords1 = ExcelUtility.readStringData(1, 1, "AdminUserPage");
		
		// username password for Staff
       //AdminUserspage adminpage = new AdminUserspage(driver);
        FakerUtility faker=new FakerUtility();
        String usernames1=faker.createRandomFirstName();
        String passwords1=faker.createRandomLastName();
		adminuserspage=homepage.clickOnadminUsersMoreInfo();
		adminuserspage.clickAdminNewTab().userTab(usernames1).passwordTab(passwords1).selectUserType().clicksaveButton();
		//adminuserspage.userTab(usernames1);
		//adminuserspage.passwordTab(passwords1);
		//adminuserspage.selectUserType();
		//adminuserspage.clicksaveButton();
		boolean alertMessage1 = adminuserspage.alertDisplay();
		Assert.assertTrue(alertMessage1,Constant.USERISABLETOACCESSADMINUSERS);	
	}
}

