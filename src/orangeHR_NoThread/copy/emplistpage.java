package orangeHR_NoThread.copy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class emplistpage extends baseClass { 

		@FindBy(xpath="//div[@role='table']//div[1]//div[1]//div[6]//div[1]//button[2]")
		@CacheLookup
	    private WebElement editemp;
		
		emplistpage(){
			PageFactory.initElements(getDriver(), this);
		}
		public  editEmPage editEmployee() {
		   editemp.click();
		   return new editEmPage();
}
}