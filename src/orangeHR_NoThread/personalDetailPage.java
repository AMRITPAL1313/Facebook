package orangeHR_NoThread;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class personalDetailPage extends baseClass {
	@FindBy(xpath="//input[@data-v-1f99f73c='']")
	@CacheLookup
	private WebElement idbox;
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item active']")
	@CacheLookup
	private WebElement pimbtn;
  
  	@FindBy (xpath = "//input[@placeholder='First Name']")
  	private WebElement fnamebox;
  
  	@FindBy(xpath="//input[@placeholder='Last Name']")
    @CacheLookup 
    private WebElement lnamebox; 
  	
  	@FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
  	@CacheLookup
  	private WebElement PCollingsbox;
  	
  	@FindBy(xpath = "//a[normalize-space()='Logout']")
  	@CacheLookup
  	private WebElement logoutbtn;
  	
	
	
   public	personalDetailPage(){
  		PageFactory.initElements(getDriver(), this);
  	}
   public PIMPage extractln() {
       WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(lnamebox));
       String employeeln = lnamebox.getAttribute("value");
       System.out.println("Employee Last Name: " + employeeln);
       pimbtn.click();
       return new PIMPage();
   } 
   public void extractname() throws InterruptedException {
   
   	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(fnamebox));
       String firstName = fnamebox.getAttribute("value");
       System.out.println("First name: Amritpal " + firstName);
       if (firstName == "Amritpal") {
       	 System.out.print("First name is incorrect");
       } else {
           System.out.println("First name is correct");
       }
	
   }
    public loginpageHRM loclick() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(PCollingsbox)).click();
    PCollingsbox.click();
    logoutbtn.click();
    return new loginpageHRM();
} 
}