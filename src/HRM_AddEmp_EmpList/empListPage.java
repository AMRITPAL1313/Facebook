package HRM_AddEmp_EmpList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class empListPage extends baseDP{
	
	@FindBy(xpath="//nav/ul/li[3]/a")
	private WebElement addEmpTab;
	
	public empListPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public addEmpPage clickAddEmpTab() throws InterruptedException {
		addEmpTab.click();
		Thread.sleep(3000);
		return new addEmpPage();
		
	}

}
