package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage 
{

	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and @class='small-box-footer']")WebElement managecategorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement newtab;
	@FindBy(xpath="//input[@name='category']")WebElement category;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement groups;
	@FindBy(xpath="//input[@id='main_img'and @name='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public WebDriver driver;
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	/*public void clickOnManageCategoryMoreInfo()
	{
		PageUtility page =new PageUtility();
		page.javaScriptExecutorClick(driver,managecategorymoreinfo);
		//moreinfo.click();
	}
	*/
	public ManageCategoryPage clickNewTab()
	{
		newtab.click();
		return this;
	}
	public ManageCategoryPage enterCategory(String text)
	{
		category.clear();
		category.sendKeys(text);
		return this;
	}
	public ManageCategoryPage clickSelectGroups()
	{
		PageUtility page =new PageUtility();
		page.javaScriptExecutorClick(driver,groups);
		//groups.click();
		return this;
	}
	
	public ManageCategoryPage uploadImage()
	{
		FileUploadUtility UploadUtility=new FileUploadUtility();
		UploadUtility.uploadUsingSendKeys(choosefile,Constant.CATEGORYIMAGE);
		PageUtility page =new PageUtility();
		page.pageFullScroll(driver);
		return this;
	}
	
	public ManageCategoryPage clickSave()
	{
		PageUtility page =new PageUtility();
		page.javaScriptExecutorClick(driver,save);
		//save.click();
		return this;
	}
	public boolean isAlertdisplayed()
    {
    	return alert.isDisplayed();
    }
}
