package MultiThread_Parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ecommerceLandingPage extends baseMultiThread{
	//private ComputersPage cp;
	
	 @FindBy(xpath="//ul[@class='top-menu notmobile']/li/a[@href='/computers']")
	 WebElement computers;
	 
	 // constructor method to initialize the webElements
	 public ecommerceLandingPage(){	
		PageFactory.initElements(getDriver(), this);
	 }
	 
	 public ComputersPage clickComputers() throws InterruptedException {
		 computers.click();
		 Thread.sleep(3000);
		 return new ComputersPage();
	 }
	 
}