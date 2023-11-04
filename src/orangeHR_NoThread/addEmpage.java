package orangeHR_NoThread;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import HRM_AddEmp_EmpList.EmpDetailPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class addEmpage extends baseClass {
	
	@FindBy(xpath="//a[normalize-space()='Add Employee']")
    private WebElement addemp;
	
	//input[@placeholder='First Name']
	@FindBy(xpath="//input[@placeholder='First Name']")
	@CacheLookup
	private WebElement firstnamebox;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	@CacheLookup
	private WebElement lastnamebox;
	
	@FindBy(xpath = "div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']")
	@CacheLookup
	private WebElement IDbox;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
    private WebElement savebutton;
	
        public addEmpage() {
		PageFactory.initElements(getDriver(), this);
		}
        
    		empid= empID.getAttribute("value");
    		
     public personalDetailPage aep(String firstname, String lastname) throws InterruptedException {
 		firstnamebox.sendKeys(firstname);
 		Thread.sleep(2000);
 		lastnamebox.sendKeys(lastname);
 		Thread.sleep(2000);
 		savebutton.click();
 		return new personalDetailPage();
 	}
     public String getEmpId() {
			return empID;
}
     }