package DataProviders;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest1 extends baseDP{
	
	//@BeforeClass
	@Test
	public void testbaseSetup() throws InterruptedException {
	 baseSetup("chrome", "https://freecrm.com/");
	}
	
	//https://freecrm.com/
	@DataProvider(name = "test-data")
  	public static Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Lambda Test"},
              	{"Automation"}
        	};
  	}
	
	/*==================================================
	 @DataProvider(name="testdata")
@DataProvider(name="testdata")
public Object[][] TestDataFeed(){

// Create object array with 2 rows and 2 column- 
 //first parameter is row and second is column
Object [][] twitterdata=new Object[2][2];

// Enter data to row 0 column 0
twitterdata[0][0]="username1@gmail.com";
// Enter data to row 0 column 1
twitterdata[0][1]="Password1";
// Enter data to row 1 column 0
twitterdata[1][0]="username2@gmail.com";
// Enter data to row 1 column 0
twitterdata[1][1]="Password2";
// return arrayobject to testscript
return twitterdata;
}
	
	=========================================================== */
	

}
