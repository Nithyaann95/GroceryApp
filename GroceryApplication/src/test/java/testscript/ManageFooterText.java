package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterText extends Base

{
	public HomePage homepage;
	public ManageFooterPage managefooterpage;
	
	@Test (description="This test case verifies that a valid user can log in to the application, "
			          + "navigate to the Manage Footer Text section, update the footer details such as email "
		              + "and phone number, and successfully save the changes. "
			          + "It also ensures that a confirmation alert is displayed after updating the footer information.")
	
			public void verifyUserCanCreateManageFooter() throws IOException // valid Username and Password
	{

		// String username= "admin"; // Valid Username and Valid Password
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String address = ExcelUtility.readStringData(1, 0, "ManageFooterPage");
		String email = ExcelUtility.readStringData(1, 1, "ManageFooterPage");
		String phone = ExcelUtility.readIntegerData(1, 2, "ManageFooterPage");
		
		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSigninButton();
		
		//ManageFooterPage footer= new ManageFooterPage(driver);
		managefooterpage=homepage.clickOnManageFooterMoreinfo();
		managefooterpage.clickAction().enterAddress(address).enterEmail(email).enterphone(phone).updateDetails();
		//String address = ExcelUtility.readStringData(1, 0, "ManageFooterPage");
		//footer.enterAddress(address);
		//String email = ExcelUtility.readStringData(1, 1, "ManageFooterPage");
		//footer.enterEmail(email);
		//String phone = ExcelUtility.readIntegerData(1, 2, "ManageFooterPage");
		//footer.enterphone(phone);
		//footer.updateDetails();
		boolean alertmessage = managefooterpage.alertdisplayed();
	    Assert.assertTrue(alertmessage,Constant.USERISABLETOACCESSMANAGEFOOTERTEXT);
}
}
