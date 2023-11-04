package FaceBook_NoThread;


	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class accountPage extends baseClass{
			WebDriver driver;
			loginPage lp;
			
			@FindBy(xpath="//div[@aria-label='Account Controls and Settings']/span/div/div[1]")
			@CacheLookup
		    private WebElement account;
			
			@FindBy(xpath="//div[@role='list']/div[5]")
			@CacheLookup
		    private WebElement logout;
			
			//WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='list']/div[5]")));
			public accountPage(){
				PageFactory.initElements(getDriver(), this);
			}
			
			public loginPage logout() {
				account.click();
				WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
				return new loginPage();
			}
			
			 public String getUrl() {
				 return getDriver().getCurrentUrl();
			 }
			 
			 public String getTitle() {
				 return getDriver().getTitle();
				 
				 
			 }
	}


