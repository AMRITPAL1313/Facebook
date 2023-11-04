		package orangeHR_NoThread;
		
		import java.io.File;
		import java.io.IOException;
		
		import java.time.Duration;
		import java.util.Date;
		import java.text.SimpleDateFormat;
		import org.apache.commons.io.FileUtils;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.firefox.FirefoxOptions;
		import org.openqa.selenium.firefox.FirefoxProfile;

	    public class baseClass{
	    	
		public static  WebDriver driver;
		
		public static void takeScreenShot() throws IOException {
	        // Take Screenshot for Evidence
	        File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        File targetfile = new File(System.getProperty("user.dir")+"/Screenshots/"+"FbStatus_"+datetime+".png");
	        /*
	        String targetfile= "c:\\Users\\Sri\\Desktop\\FbStatus_";
	        targetfile = targetfile.concat(datetime);
	        targetfile = targetfile.concat(".png");*/
	       
	        System.out.println(targetfile);
	        // Save the screenshot in the given path by the name FbStatus.png
	        FileUtils.copyFile(srce, targetfile);
	       
	    }	    public void baseSetup(String browser, String url) { 
	
	    String chrpath= "C://AMRIT DOCS//Facebook//Browsers//chromedriver.exe";
	    String ffpath="C://AMRIT DOCS//Facebook//Browsers//geckodriver.exe";
	
		switch(browser) {
	
		case "firefox":
		// disable all notification in firefox browser
		FirefoxOptions ffoptions = new FirefoxOptions();
		ffoptions.setProfile(new FirefoxProfile());
		ffoptions.addPreference("dom.webnotifications.enabled", false);
		ffoptions.setBinary("C://Program Files//Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.gecko.driver",ffpath);
	
		FirefoxDriver ffdriver = new FirefoxDriver(ffoptions);
		driver = ffdriver;
		break;
	
	   case "chrome":
	
		ChromeOptions chroptions = new ChromeOptions();
		chroptions.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", chrpath);
		ChromeDriver chrdriver = new ChromeDriver(chroptions);
		driver = chrdriver;
	   break;
	   default:
	    
		  System.out.println("Browser name unrecognized!. please enter either chrome or firefox");
	   }
     getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     getDriver().get(url);
     getDriver().manage().window().maximize();
	  }
	    
       public WebDriver getDriver() {
        return driver;
       }
	      public void tearDown() {	
	        getDriver().quit();
	        }
	}
	
	
	
	
	
	
