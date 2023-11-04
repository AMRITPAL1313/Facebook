package DataProviderDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dpDemo extends baseDataProver{
	
	@BeforeClass
	public void setup() throws InterruptedException {
		baseSetup("chrome", "http://google.com");
	}
	
	@DataProvider(name = "test-data")
  	public Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Lambda Test"},
              	{"Automation"}
        	};
  	}
	
	//Passing the dataProvider to the test method through @Test annotation
  	@Test(dataProvider ="test-data")
  	public void search(String keyWord) throws InterruptedException {
    	WebElement txtBox = getDriver().findElement(By.id("APjFqb"));
    	  txtBox.sendKeys(keyWord);
    	  txtBox.sendKeys(Keys.ENTER);
    	  Thread.sleep(3000);
    	  getDriver().navigate().back(); 
    	  Thread.sleep(3000);
    	  txtBox.clear();
       }
	

}
