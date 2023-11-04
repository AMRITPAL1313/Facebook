package orangeHR_NoThread;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataProviders.utils;

public class spreadSheetHRM {
	public class testHRMPage_testNG extends baseClass {
		private HomepageHRM hmp;
		private loginpageHRM  lgp;
	    private emplistpage  elp;
		private editEmPage eep;
		private PIMPage pim;
	    private addEmpage aep;
	    private personalDetailPage pdp;
	    
	    @BeforeClass
	    public void testSetup(){
	  		baseSetup("chrome","https://opensource-demo.orangehrmlive.com/");
	         
	  	}
	    @Test(priority=1)
		public void pimclick() {
			pim = hmp.pimclick();
			Assert.assertNotNull(pim);
		}
		
		
		@Test (priority=2)
		public void addemployee() throws InterruptedException {
			aep = pim.clickAddEmpTab();
			Assert.assertNotNull(aep);
		}
		
		
		@DataProvider(name = "excel-testdata")
	  	public static Object[][] excelData() throws IOException{
	        	return new utils().ReadData();
	  	}
		
		@Test (priority=3,  dataProvider="excel-testdata") 
		public void addempnames(String firstname, String lastname) throws InterruptedException {
			eep = aep.addemp(firstname, lastname);
			eep.clickaddEmpTab();
		
		} 
	}
}
		
	   
