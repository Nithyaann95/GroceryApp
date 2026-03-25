package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base

{
	public HomePage homepage;
	public ManageNewsPage managenewspage;
	
	@Test  (description="This test case verifies that a valid user can log in to the application, "
			           +"navigate to the Manage News section, create a new news entry by providing the required information, "
		               +"and successfully save it.")
	
	public void verifyTheUserAbleToManageNewsPage() throws IOException // valid Username and password
	{
		// String username= "admin"; // valid username and valid password
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); 
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String text = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
	    homepage=loginpage.clickOnSigninButton();
		//ManageNewsPage newspage = new ManageNewsPage(driver);
		managenewspage=	homepage.clickOnmanageNewsMoreInfo();
		managenewspage.clickOnNewTab().enterNews(text).clickOnSave();
		
		//newspage.enterNews(text);
		//newspage.clickOnSave();
		boolean alertMessage = managenewspage.alertDisplay();
		Assert.assertTrue(alertMessage,Constant.USERISABLETOACCESSMANAGENEWS);
	}

}
