package FaceBook_NoThread;

public class testloginPage extends baseClass{
	
		
			static accountPage hp;
		    static loginPage lp;
			
	public static void main(String[] args) throws InterruptedException {
	baseSetup("chrome", "https://www.facebook.com/");
				
	lp = new loginPage();
	// test-1
	if(lp == null) {
		System.out.println("FaceBook application launch has failed!");
		}else {
	System.out.println("FaceBook application launch successful!");
	}
	    //fb.setup("chrome", "https://www.facebook.com/");
	  //test-2
		System.out.println(lp.getTitle());//Facebook - log in or sign up
		System.out.println(lp.getUrl());//https://www.facebook.com/
				
		//test-3
		hp = lp.login("amritkaursidhu2020@gmail.com", "AK@123456789");
		  if(hp == null) {
		System.out.println("Login failed!");
		   }else {
		System.out.println("Login is successful!");
		}
				
	Thread.sleep(5000);
		//test-4
	System.out.println(hp.getTitle());//(20+) Facebook
				
	   lp = hp.logout();
				
	//test-5
		if(lp == null) {
			System.out.println("Logout failed!");
		}else {
			System.out.println("Logout is successful!");
				}
			}

	}

