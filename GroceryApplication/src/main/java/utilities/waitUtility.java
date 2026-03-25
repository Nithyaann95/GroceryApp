package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtility 
{
public static final int IMPLICITWAIT=5;
public static final int EXPLICITWAIT=10;

public void waitFORElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}	

public void waitFORElementToBeSelected(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}

public void waitFORVisibilityOfAllElements(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.visibilityOfAllElements(element));
}

public void waitFORInvisibilityOfAllElements(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.invisibilityOfAllElements(element));
}

}

