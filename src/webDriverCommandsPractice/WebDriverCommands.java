package webDriverCommandsPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import FaceBook_NoThread.baseClass;

public class WebDriverCommands extends baseClass{
    private WebDriver driver;
  
  @BeforeClass 
  private void baseSetup() {
	  baseSetup("chrome","http://172.16.121.146/webdriver-demo-site/webdriver-demo-site.html");
	  driver = getDriver();
  }
  
  @Test
  public void testchkbox() {
	  WebElement chkbox= driver.findElement(By.xpath("//input[@name='drive']"));
	  boolean ret = chkbox.isSelected();
	  if(ret) {
		  System.out.println("check box is already selected");
	  }else {
		  System.out.println("check box is not selected");
		  chkbox.click();
	  }
  }
	  @Test
	  public void testchkbox1() {
		  WebElement chkbox= driver.findElement(By.xpath("//input[@name='drive']"));
		  boolean ret = chkbox.isSelected();
		  if(ret) {
			  System.out.println("check box is already selected going to deselected");
			  chkbox.click();
		  }else {
			  chkbox.click();
		  }
	  }

  @Test (enabled=false )
  private void testRdioBtn() {
	  //fieldset[1]/input [@type='radio']
	  List<WebElement> radioGroup = driver.findElements(By.xpath(" /input[@type='radio']"));
	  int num = radioGroup.size();
	  System.out.println("Total number of radio buttons in this group is: " + num );
	 
	  for(WebElement ele: radioGroup ) {
		  //System.out.print(ele.getText());
		  String value = ele.getDomAttribute("value");
		  if(ele.isSelected()) {
			System.out.println(value +" : Radio button is selected");
		  }else {
			  System.out.println(value +" : Radio button is not selected");   
		  }
	  }   
	  }

	  @Test
	 private void testSingleSelection() throws InterruptedException {
		  // select[@name='Mobiles']
		  WebElement selectSingle= driver.findElement(By.xpath("//select[@name='Mobiles']"));
		  Select dropdown=new Select(selectSingle);
	  
	  List<WebElement> options = dropdown.getOptions();
	  for(WebElement listItem : options) {
		  System.out.println( listItem.getText());
	  }
	  
	  dropdown.selectByValue("4");//HTC
	  Thread.sleep(5000);
	  dropdown.selectByVisibleText("Samsung");
	  Thread.sleep(5000);
	  dropdown.selectByIndex(2);//nokia
	  }
	
	  @Test
	  private void testMultipleSelection() {
	  
	  }
	  
	  @Test
	  private void testAlertWindow() {
	  
	  }
	  @Test
	  private void testPromptBox() {
	  
	  }
	  
	  @Test
	  private void testIframe() {
	  
	  }
	  @Test
	  private void testLinkToNewTab() {
	  
	  }
	  
}
	  
	
