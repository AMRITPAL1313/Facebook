package orangeHR_NoThread;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

	   public class testHRM extends baseClass  {
		   
	   static HomepageHRM hmp;
	   static loginpageHRM  lgp;
	   static emplistpage  elp;
	   static editEmPage eep;
	   static addEmpage aep;
	  static PIMPage pim;
	   
		public static void main(String[] args) throws InterruptedException {
			
			 baseSetup("firefox","https://opensource-demo.orangehrmlive.com/");
		
			lgp = new loginpageHRM();
			hmp=lgp.login("Admin","admin123");
			hmp =new HomepageHRM();
		   elp=hmp.adminClick();
		   eep= elp.editEmployee();
		  pim = hmp.pimclick();
		   eep.selectbox();
		   
		
		// test-1
			if(lgp == null) {
				System.out.println("orangeHRM application launch has failed!");	
			}else {
				System.out.println("orangeHRM application launch successful!");
				}
				   
		//test-2
		    System.out.println(lgp.getTitle());//orangeHRM - log in or sign up
			System.out.println(lgp.getUrl());//https://opensource-demo.orangehrmlive.com/
							
		//test-3
			 hmp = lgp.login("Admin","admin123");
			 if(hmp == null) {
			System.out.println("Login failed!");
			  }else {
			System.out.println("Login is successful!");
					}
			
			  // Test 3
		       // if (pim == null) {
		            System.out.print("PIM page failed to load");
		        //} else {
		            System.out.println("PIM page loaded");
		       // }
		        // test-4
		       // aep = pim.addemployee();
	
		        if (aep == null) {
		            System.out.print("Add Employee page failed to load");
		        } else {
		            System.out.println("Add Employee page loaded");
		        }
	
		        if (pdp == null) {
		            System.out.print("Failed to add employee");
		        } else {
		            System.out.println("Employee added successfully");
		            
	 Thread.sleep(5000);
			//test-4
			System.out.println(hmp.getTitle());//(20+) orangeHRM				
			lgp = eep.logout();
							
		//test-5
			if(lgp == null) {
			System.out.println("Logout failed!");
		 }else {
			System.out.println("Logout is successful!");
		 }
		         	
		
	   
	
