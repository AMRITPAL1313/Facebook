package WebDriver_Commands_PracticeDemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import orangeHR_NoThread.baseClass;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class MiscCommands extends baseClass{
  String url = "C://AMRIT DOCS//Facebook//src//WebDriver_Commands_PracticeDemo//webdriver-demo-site.html";
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  baseSetup("chrome", url);
	  driver = getDriver();
  }
  @Test(enabled=true )
  public void testchkbox()throws IOException {
	//input[@name='drive']
	//input[@type='checkbox']
	 WebElement chkbox= driver.findElement(By.xpath("//input[@name='drive']"));
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertNotNull(null,"Check box element not found");
	 takeScreenShot();
	  softAssert.assertAll();
	  
	 // WebElement chkbox= driver.findElement(By.name("drive"));
	 // WebElement chkbox= driver.findElement(By.xpath("//input[@name='drive']"));
	  if(chkbox.isSelected()) {
	
		  System.out.println("check box is already selected");
	  }else {
		  chkbox.click();
		  System.out.println("check box is not selected");
		 
	  } 
  }
   
  @Test (enabled=false )
  private void testRdioBtn() {
	  //fieldset[1]/input [@type='radio']
	
	 java.util.List<WebElement> radioGroup = driver.findElements(By.xpath(" //fieldset[1]/input [@type='radio']"));
	  int num = radioGroup.size();
	  System.out.println("Total number of radio buttons in this group is: " + num );
	 
	  for(WebElement ele: radioGroup ) {
		  //System.out.print(ele.getText());
		  String value = ele.getDomAttribute("value");
		  if(ele.isSelected()) {
			System.out.println(value +" : Radio button is selected");
		  }else {
			  System.out.println(value +" : Radio button is not selected");   
			  ele.click();
		  }
	  }
  }
  
  @Test(enabled=false )
  public void selectOptions() {
	  List<WebElement> CellOptions = driver.findElements(By.xpath("//select[@name='Mobiles']/option"));
	  for (WebElement ele : CellOptions) {
		  System.out.println(ele.getText());
	  }
  }
  
  /*
  //Multiple Selection Example
  //#1) selectByVisibleText() and deselectByVisibleText() 
  //2) selectByValue() and deselectByValue()
  //#3) selectByIndex() and deselectByIndex()
  //#4) isMultiple()
  //#5) deselectAll()
   
  //Multiple Selection Example
  @Test (enabled = false)
  public void testMutiSelect() {
	//select[@name='Mobdevices']
	  WebElement multiSelect= driver.findElement(By.xpath("//select[@name='Mobdevices']"));
	  Select phones = new Select(multiSelect);
	  if (phones.isMultiple()) {
		  System.out.println("This selection box is multiple selection box");
	  }
	  
	  phones.selectByVisibleText("Nokia");
	  phones.selectByIndex(3);//samsung
	  phones.selectByValue("5");//blackberry
	  
	  phones.deselectAll();
	  
	  // lab 1 - print all the items names from the multi select element
	  // "//select[@name='Mobdevices']/option"
	  
  }
*/
      //Alert Box Example
      @Test (enabled = false)
      public void testAlertBox() {
	  
	  //button[@onclick='alertFunction()']
	  WebElement btn = driver.findElement(By.xpath("//button[@onclick='alertFunction()']"));
	  btn.click();
	  try {
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
	  }catch(NoAlertPresentException ex){
		    System.out.println("Alert is NOT Displayed");
	  }
  }
  
    //Prompt Box Example
    @Test(enabled = false)
    public void testPromptBox() throws InterruptedException {
	  
	  WebElement btn = driver.findElement(By.xpath("//button[@onclick='promptFunction()']"));
	  WebElement promptMsg = driver.findElement(By.xpath("//p[@id='promptdemo']"));
	  btn.click();
	  try {
		  Alert alert = driver.switchTo().alert();
		  alert.sendKeys("vasanth");
		  Thread.sleep(3000);	  
		  alert.accept();
		  Thread.sleep(3000);	
		  System.out.println(promptMsg.getText());
		  //alert.dismiss();
	  }catch(NoAlertPresentException ex){
		    System.out.println("Alert is NOT Displayed");
	  }
  }
  
      //iFrame Example
      @Test (enabled = false)
      public void testIframe() throws InterruptedException {
	  
	  int size = driver.findElements(By.tagName("iframe")).size();
	  System.out.println("number of frames in this page is: " +size);
	  
	  driver.switchTo().frame(0);
	  try {
		  WebElement flashcard = driver.findElement(By.xpath("//a[@href='/flashcards-list']"));
		
		  // Javascript executor
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", flashcard);
	      Thread.sleep(3000);
	      flashcard.click();
	   }catch(ElementNotInteractableException e) {
		  System.out.println("iframe flahscard element problems");
	   }
	   // go back to main page from iframe
	   driver.switchTo().defaultContent();
   }
  
     //New Tab window to LinkedIn page
     @Test
     public void testNewTabWindow() throws InterruptedException {  
      	
	  //Check we don't have other windows open already
	  assert driver.getWindowHandles().size() == 1;  
	//Store the ID of the original window
	  String originalWindow = driver.getWindowHandle();
	
	  //*[@id="subscribe"]/div/div/a
	  WebElement linkedIn=driver.findElement(By.xpath("//section[@id='subscribe']/div/div/a"));
	  
	  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", linkedIn);
	  Thread.sleep(5000);
	  linkedIn.click();
	  
	  Thread.sleep(5000);
	  assert driver.getWindowHandles().size() == 2;  

	  String newTabWindow = null;
	  //Loop through until we find a new window handle
	  for (String windowHandle : driver.getWindowHandles()) {
	      if(!originalWindow.contentEquals(windowHandle)) {
	          driver.switchTo().window(windowHandle);
	          System.out.println(driver.getTitle());
	          newTabWindow = windowHandle;
	          break;
	      }      
	  }
	  driver.switchTo().window(originalWindow);
	  Thread.sleep(5000);
	  
	  driver.switchTo().window(newTabWindow);
	  Thread.sleep(5000);
	  driver.close();
	  
	  driver.switchTo().window(originalWindow);
	  Thread.sleep(5000);
	  
   }
  
     @AfterClass
     public void afterClass() {
	  //driver.close();
   } 
 }

