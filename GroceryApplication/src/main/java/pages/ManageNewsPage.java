package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitUtility;

public class ManageNewsPage 
{
	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @onclick='click_button(1)']")WebElement newButton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement enternews;
	@FindBy(xpath = "//button[@name='create']")WebElement save;
	//@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickOnmanageNewsMoreInfo() 
	{
		managenewsmoreinfo.click();
	}
	*/

	public ManageNewsPage clickOnNewTab() 
	{
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNews(String text) 
	{
		enternews.sendKeys(text);
		return this;
	}

	public ManageNewsPage clickOnSave() 
	{
		save.click();
		return this;
	}

	public boolean alertDisplay() 
	{
		return alert.isDisplayed();
	}
}