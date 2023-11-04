package DataProviders;

import java.io.IOException;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class CustomSoftAssert extends SoftAssert{
	
	public void onAssertFailure(IAssert<?> var1,AssertionError var2) {
		try {
			new utils().takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
