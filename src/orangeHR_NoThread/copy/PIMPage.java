package orangeHR_NoThread.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage extends baseClass{
	WebDriver driver;
     PIMPage pim;
     loginpageHRM lgp;
     HomepageHRM hmp;
     
     
     @FindBy(xpath = "//button[normalize-space()='Add']")
     @CacheLookup
 	private WebElement addbutton;
 	
     PIMPage(){
  		PageFactory.initElements(getDriver(), this);
  	}
     
     
 	public addEmpage addemployee() {
 		addbutton.click();
 		return new addEmpage();
 	}
 	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
 	@CacheLookup
 	private WebElement searchLN;
     
 	@FindBy(xpath= "//button[@type='submit']")
	@CacheLookup
	private WebElement searchbtn;
 	

 	public PIMPage searchemp(String Lname) {
 		searchLN.sendKeys(Lname);
 		searchbtn.click();
 		return new PIMPage();
 	}
 	
 	@FindBy(xpath = "div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']")
 	@CacheLookup
 	private WebElement idbox;
 	
 	
 	
 	@FindBy(xpath = "//input[@placeholder='First Name']")
 	@CacheLookup
 	private WebElement employeepersonaldetailPage;
 	
 	
 	
 	@FindBy(xpath = "//div[contains(text(),'Amritpal')]")
 	@CacheLookup
 	private WebElement emprecord;
 	
 	
 	public  personalDetailPage selectemp() {
 		emprecord.click();
 		return new personalDetailPage();
 	}
}
