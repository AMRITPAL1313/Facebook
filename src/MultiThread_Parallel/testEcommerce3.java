package MultiThread_Parallel;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testEcommerce3 extends baseMultiThread{
	private ecommerceLandingPage lp;
	private ComputersPage cp;
	
	@BeforeClass
	public void appSetup() throws InterruptedException  { 
	lp = baseSetup("chrome", "https://demo.nopcommerce.com/");
	Assert.assertNotNull(lp);
	}
	
	@Test
	public void testClickComputers() throws InterruptedException {
		cp = lp.clickComputers();
		Assert.assertNotNull(cp);
	}
	
}
