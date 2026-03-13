package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Username']")WebElement userfield;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signfield;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath = "//div [contains(@class,'alert-dismissible')]")WebElement alert;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public void enterTheUsername(String username) 
	{
    	userfield.sendKeys(username);
	}

	public void enterThePassword(String password) 
	{
		passwordfield.sendKeys(password);
	}

	public void clickOnSigninButton() 
	{
		signfield.click();
	}
	public boolean isDashboardDisplayed() 
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
