package orangeHR_NoThread.copy;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	
    @Test(priority = 1)
    public void testloginpage() {
	   lgp = new loginpageHRM();
	   SoftAssert softAssert = new SoftAssert();
	   softAssert.assertNotNull(lgp,"login is not displayed");
	   hmp = lgp.login("Admin","admin123");
    }
	 // lgp=null;
	   
	   //Assert.assertNotNull(lgp,"login page is not displayed..");
	   //softAssert.assertNotNull(null,"login has failed");
	  //System.out.println("software has been executed and failed");
		
    
    /*
     @Test(priority =5)
	public void testClickadmin() {
		  elp = hmp.adminClick();
		  Assert.assertNotNull(elp);
	}
	
	@Test(priority = 7)
	public void testEditemp() throws InterruptedException {
		eep= elp.editEmployee();
		 Assert.assertNotNull(eep);
	}
	
	@Test(priority = 9)
	public void ExtractBox() {
		  eep.selectbox();
		  Assert.assertNotNull(eep);
	}
	
	@Test(priority = 7)
	public void testlogout() {
		getDriver().navigate().refresh();
		  eep.logout();
	}
	
	@Test (priority=11)
	public void testGetName() {
		System.out.println(eep.getEmpName());
	}
    
     @Test (priority=1)
     public void testClickPIM() {
    	 pim = hmp.PIMbutton();
    	 SoftAssert softAssert4 = new SoftAssert();
		softAssert4.assertNotNull(pim, "PIM button failed");
    	 SoftAssert softAssert3 = new SoftAssert();
		softAssert3.assertAll();
     }
     @Test(priority=3)
 	public void testAddEmployee() {
 		aep = pim.addbutton();
 		softAssert.assertNotNull(aep, "AEP button failed");
 		softAssert.assertAll();
 	}
 
 	@Test(priority=2)
 	public void testAddNewEmployee() {
 		aep.pim("Amritpal","Kaur");
 		softAssert.assertNotNull(aep, "failed to enter name");
 		softAssert.assertAll();
 	}
 	
 	@Test(priority=7)
 	public void testreturntoPIM() {
 		pim = hmp.PIMbutton();
 		softAssert.assertNotNull(pim,"pim button unsuccessful");
 		softAssert.assertAll();
 	}
 	*/
 	/*@Test(priority=12)
 	public void testSearchEmployee() {
 		pim.pim("0290");
 		SoftAssert softAssert = new SoftAssert();
 		softAssert.assertNotNull(pim,"employee failed to be found");
 		softAssert.assertAll();
 	}*/
 	/*
 	@Test(priority=9)
 	public void testLogout() {
 		pdp = new personalDetailPage();
 		pdp.logout();
 	}
*/
	@Test(priority=2)
	public void pimclick() {
		pim = hmp.PIMbutton();
		Assert.assertNotNull(pim);
	}
	
	@Test(priority=3)
	public void addemployee() {
		aep = pim.addemployee();
		Assert.assertNotNull(aep);
	}
	
	@Test(priority=4)
	public void extractID() {
		aep.extractID();
		Assert.assertNotNull(aep);
	}
	
	@Test(priority=5)
	public void addEmpage() throws InterruptedException {
		aep.aep("Amritpal", "Kaur");
		Assert.assertNotNull(pdp);
		
	} 
	
	@Test(priority=6)
	public void extractln() {
		pim = pdp.extractln();
	Assert.assertNotNull(pim);
	}
	
	@Test(priority=7)
	public void searchempt() {
		 pim.searchemp("Kaur");
	Assert.assertNotNull(lgp);
	}

	@Test(priority=8)
	public void selectemp() {
		pdp =  pim.selectemp();
	Assert.assertNotNull(lgp);
	}
	
	@Test(priority=9)
	public void extractname() throws InterruptedException {
		pdp.extractname();
	Assert.assertNotNull(lgp);
	}
	
	@Test(priority=10)
	public void logoutclick() {
		lgp = pdp.loclick();
	Assert.assertNotNull(lgp);
	}

		@AfterClass
	 public void testTearDown() {
		 tearDown();
	 } 
}