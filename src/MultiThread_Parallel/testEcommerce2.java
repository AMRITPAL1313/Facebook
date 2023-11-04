package MultiThread_Parallel;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testEcommerce2 extends baseMultiThread{
	private ecommerceLandingPage lp;
	private ComputersPage cp;
	
	@BeforeClass
	public void appSetup() throws InterruptedException  { 
	lp = baseSetup("firefox", "https://demo.nopcommerce.com/");
	Assert.assertNotNull(lp);
	}
	
	@Test
	public void testClickComputers() throws InterruptedException {
		cp = lp.clickComputers();
		Assert.assertNotNull(cp);
	}
	
}
