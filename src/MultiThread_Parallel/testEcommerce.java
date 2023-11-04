package MultiThread_Parallel;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testEcommerce extends baseMultiThread{
	private ecommerceLandingPage lp;
	private ComputersPage cp;
	private CustomSoftAssert softAssert = new CustomSoftAssert();
		
	@BeforeClass
	public void appSetup() throws InterruptedException, IOException  { 
	lp = baseSetup("chrome", "https://demo.nopcommerce.com/");
	softAssert.assertNotNull(lp,"landing page failure!");
	softAssert.assertAll();
	}
	
	@Test
	public void testClickComputers() throws InterruptedException {
		cp = lp.clickComputers();
		softAssert.assertNotNull(cp,"computer link click failure!");
		softAssert.assertAll();
	}
	
}
