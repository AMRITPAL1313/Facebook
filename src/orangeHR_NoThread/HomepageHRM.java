package orangeHR_NoThread;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import FaceBook_NoThread.loginPage;

public class HomepageHRM extends baseClass {
	public HomepageHRM hmp;
	loginPage lgp;
	
	@FindBy(xpath="//a[@href='/web/index.php/admin/viewAdminModule']")
	@CacheLookup
    private WebElement admin;
	
	@FindBy(xpath="//div[@role='list']/div[5]")
	@CacheLookup
    private WebElement logout;
	
	@FindBy(xpath = "//span[normalize-space()='PIM']")
	private WebElement PIMbutton;
	
	//WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='list']/div[5]")));
	
	public HomepageHRM(){
		PageFactory.initElements(getDriver(), this);
	}
	
/*	public emplistpage adminClick() {
		admin.click();
		return new emplistpage();
	}
	*/
	public PIMPage PIMbutton() {
		PIMbutton.click();
		return new PIMPage();
	}

	 public String getUrl() {
		 return getDriver().getCurrentUrl();
	 }
	 
	 public String getTitle() {
		 return getDriver().getTitle();
	 }

	public emplistpage adminClick() {
		// TODO Auto-generated method stub
		return null;
	}

	public PIMPage pimclick() {
		// TODO Auto-generated method stub
		return null;
	} 
	 }

