package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterPage 
{
	public WebDriver driver;
	public ManageFooterPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement action;
	@FindBy(xpath="//textarea[@name='address']")WebElement address;
	@FindBy(xpath="//input[@name='email']")WebElement email;
	@FindBy(xpath="//input[@name='phone']")WebElement phone;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	/*public void clickOnManageFooteMoreinfo()
	{
	moreinfo.click();
	}
	*/
	
	public ManageFooterPage clickAction()
	{
	action.click();
	return this;
	}
	public ManageFooterPage enterAddress(String adrs)
	{
	address.clear();
	address.sendKeys(adrs);
	return this;
	}
	public ManageFooterPage enterEmail(String mail)
	{
	email.clear();	
	email.sendKeys(mail);
	return this;
	}
	public ManageFooterPage enterphone(String number)
	{
	phone.clear();	
	phone.sendKeys(number);
	return this;
	}
	public ManageFooterPage updateDetails()
	{
	PageUtility page=new PageUtility();
	page.javaScriptExecutorClick(driver, update);
	return this;
	}
	public boolean alertdisplayed()
    {
    	return alert.isDisplayed();
    }
}
