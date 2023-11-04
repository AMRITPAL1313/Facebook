package HRM_AddEmp_EmpList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends baseDP{
		
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	public loginPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public dashboardPage login(String un, String password) throws InterruptedException {
		username.sendKeys(un);
		pwd.sendKeys(password);
		submit.click();
		Thread.sleep(3000);
		return new dashboardPage();
	}

}
