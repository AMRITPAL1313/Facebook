package HRM_AddEmp_EmpList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage extends baseDP{
	

	@FindBy(xpath="//a[@href='/web/index.php/pim/viewPimModule']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	private WebElement pim;
	
	public dashboardPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public empListPage clickPIM() throws InterruptedException {
		pim.click();
		Thread.sleep(3000);
		return new empListPage();
		
	}

}
