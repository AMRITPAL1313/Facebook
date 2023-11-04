
package orangeHR_NoThread.copy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class loginpageHRM extends baseClass {
	 HomepageHRM hmp;
	@FindBy(xpath="//input[@placeholder='Username']")
	@CacheLookup
	 private WebElement Username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	 private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	 private WebElement loginBtn;
	
	// constructor method to setup the three webElements
	public loginpageHRM () {
		PageFactory.initElements(getDriver(),this);
	}
	
	public HomepageHRM login(String email, String pwd) {
		Username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomepageHRM();
	}
	
	public String getUrl() {
		return getDriver().getCurrentUrl();
	}
	public String getTitle() {
	return getDriver().getCurrentUrl();
	}	

 }


















