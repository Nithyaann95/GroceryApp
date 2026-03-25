package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage 
{
	private WebDriver driver;

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logouttab;
	@FindBy(xpath = "//button[@type='submit']")WebElement submitbutton;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusermoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and @class='small-box-footer']")WebElement managecategorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'and @class='small-box-footer']")WebElement managefootermoreinfo;
	@FindBy(xpath="//a[contains(@href,'list-contact')]")WebElement managecontactmoreinfo;

	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public ManageNewsPage clickOnmanageNewsMoreInfo() 
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	public AdminUserspage clickOnadminUsersMoreInfo() 
	{
		adminusermoreinfo.click();
		return new AdminUserspage(driver);
	}
	
	public ManageCategoryPage clickOnManageCategoryMoreInfo()
	{
		PageUtility page =new PageUtility();
		page.javaScriptExecutorClick(driver,managecategorymoreinfo);
		//moreinfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageFooterPage clickOnManageFooterMoreinfo()
	{
		managefootermoreinfo.click();
		return new ManageFooterPage(driver);
	}
	
	public ManageContactPage clickOnManageContactMoreInfo()
	{
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}
	
	
	
	
    public HomePage clickOnAdminTab() 
    {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogOut() 
	{
		logouttab.click();
		return new LoginPage(driver);
	}

	public boolean isSubmitButtonDisplayed() 
	{
		return submitbutton.isDisplayed();
	}

}
