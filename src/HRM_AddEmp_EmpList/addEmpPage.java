package HRM_AddEmp_EmpList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addEmpPage extends baseDP{
	private String empid;
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']")
	private WebElement empID;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	public addEmpPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public EmpDetailPage saveEmp(String fn, String ln) throws InterruptedException {
		
		empid = empID.getAttribute("value");
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		submit.click();
		Thread.sleep(5000);
		//return empid;
		return new EmpDetailPage();
	}
	
	public String getEmpId() {
		return empid;
	}

}
