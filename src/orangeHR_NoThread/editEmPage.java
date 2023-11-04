package orangeHR_NoThread;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editEmPage extends baseClass {
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	@CacheLookup
    private WebElement empname;
	
	@FindBy(xpath="//img[@alt='profile picture']")
	@CacheLookup
    private WebElement profile;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	@CacheLookup
    private WebElement logout;
	
	editEmPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public editEmPage selectbox() {
		empname.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		String highlightedText = empname.getAttribute("value");
		System.out.println("Highlighted Text: "+ highlightedText);
		return new editEmPage();
	}
		
	public String getEmpName() {
	//return empname.getText();
	WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(50));
	wait.until(ExpectedConditions.elementToBeClickable(empname)).click();  
	String name = empname.getAttribute("value");
	return name;
	}
	
	 public loginpageHRM logout() {
		 //profile.click();
		 //driver.findElement(By.xpath
		 WebElement profile1 = getDriver().findElement(By.xpath("//img[@alt='profile picture']"));
		 profile1.click();
		 WebElement logoutlink= getDriver().findElement(By.xpath("//a[normalize-space()='Logout']"));
		 
		 WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(logoutlink)).click();  
			
			return new loginpageHRM();
}
	 
}