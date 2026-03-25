package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.waitUtility;

public class ManageContactPage 

{
	public WebDriver driver;

	public ManageContactPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'and @class=' nav-link']")WebElement moreinfo;
	//@FindBy(xpath="//a[contains(@href,'list-contact')]")WebElement moreinfo;
	@FindBy(xpath="//i[@class='fas fa-edit']")WebElement action;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//input[@name='email']")WebElement email;
	@FindBy(xpath="//textarea[@name='address']")WebElement address;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deliverytime;
	@FindBy(xpath="//input[@name='del_limit']")WebElement chargeLimit;
	@FindBy(xpath="//button[contains(text(),'Update')]")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	/*public void manageContactMoreInfo()
	{
		moreinfo.click();
	}
	*/
	
	public ManageContactPage clickAction()
	{
		action.click();
		return this;
	}
	public ManageContactPage enterPhoneNumber(String number)
	{
		phone.clear();
	    phone.sendKeys(number);
		return this;
	}
	public ManageContactPage enterEmail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
		return this;
	}
	public ManageContactPage enterAdress(String adrs)
	{
		address.clear();
		address.sendKeys(adrs);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String time)
	{
		deliverytime.clear();
		deliverytime.sendKeys(time);
		return this;
	}
	public ManageContactPage enterDeliveryChargeLimit(String limit)
	{
		chargeLimit.clear();
		chargeLimit.sendKeys(limit);
		return this;
	}
    public ManageContactPage clickUpdate()
    {
    	waitUtility utility=new waitUtility();
    	utility.waitFORElementToBeClickable(driver, update);
    	
    	PageUtility page = new PageUtility();
    	page.javaScriptExecutorClick(driver,update);
		return this; 	
    }
    public boolean isAlertdisplayed()
    {
    	return alert.isDisplayed();
    }
		
}





