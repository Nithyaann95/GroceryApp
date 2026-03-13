package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base

{
	@Test
	public void verifyTheUserAbleToManageNewsPage() throws IOException // valid Username and password
	{
		// String username= "admin"; // valid username and valid password
		// String password= "admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage"); 
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSigninButton();
		ManageNewsPage newspage = new ManageNewsPage(driver);
		newspage.clickOnMoreInfo();
		newspage.clickOnNewTab();
		String text = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		newspage.enterNews(text);
		newspage.clickOnSave();
		boolean alertMessage = newspage.alertDisplay();
		Assert.assertTrue(alertMessage);
	}

}
