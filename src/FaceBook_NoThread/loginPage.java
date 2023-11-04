package FaceBook_NoThread;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class loginPage extends baseClass{

		@FindBy(id="email")
		@CacheLookup
	    private WebElement emailbox;
		
		@FindBy(id="pass")
		@CacheLookup
	    private WebElement pwdbox;
		
		@FindBy(xpath="//button[@name='login']")
		@CacheLookup
	    private WebElement loginbtn;
		
		 // constructor method to setup the three webElements
		 public loginPage(){	
			PageFactory.initElements(getDriver(), this);
		 }
		 
		 public accountPage login(String email, String pwd) {
			 emailbox.sendKeys(email);
			 pwdbox.sendKeys(pwd);
			 loginbtn.click();
			 return new accountPage();
		 }
		 
		 public String getUrl() {
			 return getDriver().getCurrentUrl();
		 }
		 
		 public String getTitle() {
			 return getDriver().getTitle();
		 }
}
