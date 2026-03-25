package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility
{
	//sendkeys and robot class are used for file upload
	
	 public void uploadUsingSendKeys(WebElement element, String filepath)
	    {
	        element.sendKeys(filepath);
	    }
		
	 // Upload using Robot Class
	    public void uploadUsingRobot(String filepath) throws AWTException
	    {
	        StringSelection selection = new StringSelection(filepath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        Robot robot = new Robot();
	        robot.delay(2000);

	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);

	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_V);

	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	}