package orangeHR_NoThread;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

public class baseDataProver {
	
	// Declare ThreadLocal Driver as static to make driver thread sage
	// read notes attached herewith
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	/*
	public void takeScreenShot() throws IOException  {
		// Take Screenshot for Evidence
		File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File targetfile = new File(System.getProperty("user.dir")+"/Screenshots/"+"ErrorStatus_"+datetime+".png");
		
		System.out.println(targetfile);
		// Save the screenshot in the given path by the name FbStatus.png
		FileUtils.copyFile(srce, targetfile);
		
	}*/
	
	public  void baseSetup(String browser, String url) throws InterruptedException {
	
	String 	ffpath = System.getProperty ("user.dir") + "\\Browsers\\geckodriver.exe";
	String 	chrpath = System.getProperty ("user.dir") + "\\Browsers\\chromedriver.exe";
	
	switch(browser) {
		
	  case "firefox":
	// disable all notification in firefox browser

	    FirefoxOptions ffoptions = new FirefoxOptions();
	    ffoptions.setProfile(new FirefoxProfile());
	    ffoptions.addPreference("dom.webnotifications.enabled", false);
	    ffoptions.setBinary("C://Program Files//Mozilla Firefox/firefox.exe");
	    System.setProperty("webdriver.gecko.driver", ffpath); 
	    driver.set(new FirefoxDriver(ffoptions));
	    System.out.println("Before Test Thread ID-Firefox : "+Thread.currentThread().getId());
	    break;
	    
	  case "chrome":
		// disable all notifications in an applicaiton shown in chrome browser
		System.out.println(chrpath);
		ChromeOptions chroptions = new ChromeOptions();
		chroptions.addArguments("--disable-notifications");
		/*
		 * //Add options for --headed or --headless browser launch
           chromeOptions.addArguments("-headless");
		 */
		
		
		System.setProperty("webdriver.chrome.driver", chrpath);
		 
		driver.set(new ChromeDriver(chroptions));
		System.out.println("Before Test Thread ID-Chrome : "+Thread.currentThread().getId());
	    break;
	   
	  case "edge":
		    // code block
		    break;
	    
	  default:
	    //System.out.println("Browser name unrecognized!. please enter either chrome or firefox");
		  throw new IllegalStateException("Unexpected value: " + browser);
	}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(url);  
		getDriver().manage().window().maximize();
		//Thread.sleep(3000);
		
	}
	
	public void tearDown() {
		getDriver().close();
		driver.remove();
	}
}
