package pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserspage 
{
	public WebDriver driver;

	public AdminUserspage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusermoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']")WebElement New;
	@FindBy(xpath = "//input[@type='text' and  @id='username']")WebElement usernamevalue;
	@FindBy(xpath = "//input[@type='password' and @id='password']")WebElement passwordvalue;
	@FindBy(xpath = "//select[@name='user_type' and @id='user_type']")WebElement drop;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	//@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
/*	public void clickOnadminUsersMoreInfo() 
	{
		adminusermoreinfo.click();
	}
*/
	public AdminUserspage clickAdminNewTab() 
	{
		New.click();
		return this;
	}

	public AdminUserspage userTab(String usernames) 
	{
		usernamevalue.clear();
		usernamevalue.sendKeys(usernames);
		return this;
	}

	public AdminUserspage passwordTab(String passwords) 
	{
		passwordvalue.clear();
		passwordvalue.sendKeys(passwords);
		return this;
	}

	public AdminUserspage selectUserType() 
	{
	    PageUtility page = new PageUtility();
	    page.dropDownByValue(drop,"staff");
		return this;
	}
	
	public AdminUserspage clicksaveButton() 
	{
		save.click();
		return this;
	}

	public boolean alertDisplay() 
	{
		return alert.isDisplayed();
	}
}
