package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageCategoryText extends Base
{
	public HomePage homepage;
	public ManageCategoryPage managecategorypage;
	
	@Test (retryAnalyzer=retry.Retry.class ,description = "This test case verifies that a valid user can log in to the application, "
			                                              +"navigate to the Manage Category section, create a new category, and successfully upload a file. "
			                                              +"It ensures that the file upload functionality works as expected during category creation.")
	
	public void verifyUserCanCreateManageCategory() throws IOException // valid Username and Password
	{

		// String username= "admin"; // Valid Username and Valid Password
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSigninButton();
		
		//ManageCategoryPage categorypage=new ManageCategoryPage(driver);
		FakerUtility faker=new FakerUtility();
		String category=faker.toString();
		managecategorypage=homepage.clickOnManageCategoryMoreInfo();
		managecategorypage.clickNewTab().enterCategory(category).clickSelectGroups().uploadImage().clickSave();
		//String category = ExcelUtility.readStringData(1, 0, "ManageCategory");
		//categorypage.enterCategory(category);
		//categorypage.clickSelectGroups();
		//categorypage.uploadImage();
		//categorypage.clickSave();
		boolean alertmessage = managecategorypage.isAlertdisplayed();
	    Assert.assertTrue(alertmessage,Constant.USERISABLETOACCESSMANAGECATEGORY);
}
}
