package DataProviders;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest2 extends baseDP{
	
	@BeforeClass
	public void testbaseSetup() throws InterruptedException {
	 baseSetup("chrome", "http://google.com/");
	}
	
	@DataProvider(name = "test-data")
  	public static Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Lambda Test"},
              	{"Automation"}
        	};
  	}
	
	@DataProvider(name = "excel-testdata")
  	public static Object[][] excelData() throws IOException{
        	return new utils().ReadData();
  	}
	
	@Test(enabled=true, dataProvider="excel-testdata")
	public void testGoogleSearch(String searchKey) throws InterruptedException {
		WebElement searchText = getDriver().findElement(By.name("q"));
        //search value in google searchbox
        searchText.sendKeys(searchKey);// lambda test & automation
        searchText.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        getDriver().navigate().back();
        Thread.sleep(3000);
        searchText.clear();
	}
	
	@DataProvider(name = "mySql-testdata")
	public Object[][] getMySqlData() throws SQLException {
		Object[][] Data = new utils().mySqlData();
		return Data;
		/*int i = 1;
		System.out.print(Data[i][0]);
		System.out.print(" " + Data[i][1]);
		System.out.print(" " + Data[i][2]);
		System.out.println(" " + Data[i][3]);*/
	}
	
	@Test(enabled=false, dataProvider="mySql-testdata")
	public void testMySqlData(String id, String email, String fn, String ln) {
		System.out.print(id);
		System.out.print(" " + email);
		System.out.print(" " + fn);
		System.out.println(" " + ln);
		
	}

	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}
}
