package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base
{
	public HomePage homepage;
	public ManageContactPage managecontactpage;

	@Test (description = "This test case verifies that a valid user can log in to the application, "
			           + "navigate to the Manage Contact section, update the address information, and successfully save the changes."
		           	   + "It also ensures that a confirmation alert is displayed after updating the address.")
	
	public void verifyUserCanCreateManageContact() throws IOException // valid Username and Password
	{

		// String username= "admin"; // Valid Username and Valid Password
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); // reading from excel file
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String Phonenumber = ExcelUtility.readIntegerData(1, 0, "ManageContactPage");
		String Email = ExcelUtility.readStringData(1, 1, "ManageContactPage");
		String Address = ExcelUtility.readStringData(1, 2, "ManageContactPage");
		String Deliverytime = ExcelUtility.readIntegerData(1, 3, "ManageContactPage");
		String DeliveryChargeLimit = ExcelUtility.readIntegerData(1, 4, "ManageContactPage");
		

		LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSigninButton();
		//ManageContactPage contact=new ManageContactPage(driver);
		managecontactpage=homepage.clickOnManageContactMoreInfo();
		managecontactpage.clickAction().enterPhoneNumber(Phonenumber).enterEmail(Email).enterAdress(Address).enterDeliveryTime(Deliverytime).enterDeliveryChargeLimit(DeliveryChargeLimit).clickUpdate();
		//String Phonenumber = ExcelUtility.readIntegerData(1, 0, "ManageContactPage");
		//contact.enterPhoneNumber(Phonenumber);
		//String Email = ExcelUtility.readStringData(1, 1, "ManageContactPage");
		//contact.enterEmail(Email);
		//String Address = ExcelUtility.readStringData(1, 2, "ManageContactPage");
		//contact.enterAdress(Address);
		//String Deliverytime = ExcelUtility.readIntegerData(1, 3, "ManageContactPage");
		//contact.enterDeliveryTime(Deliverytime);
		//String DeliveryChargeLimit = ExcelUtility.readIntegerData(1, 4, "ManageContactPage");
		//contact.enterDeliveryChargeLimit(DeliveryChargeLimit);
		//contact.clickUpdate();
		boolean alertmessage = managecontactpage.isAlertdisplayed();
	    Assert.assertTrue(alertmessage,Constant.USERISABLETOACCESSMANAGECONTACT);
		
	}
}
