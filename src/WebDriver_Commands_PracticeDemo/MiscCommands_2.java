package WebDriver_Commands_PracticeDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import FaceBook_NoThread.baseClass;

public class MiscCommands_2 extends baseClass{

	  String url = "C://AMRIT DOCS//Facebook//src//WebDriver_Commands_PracticeDemo//webdriver-demo-site-2.html";
	  WebDriver driver;
	  
	  @BeforeClass
	  public void beforeClass() {
		  baseSetup("chrome", url);
		  driver = getDriver();
	  }
	  
	  //Actions Class Demo
	  @Test (enabled = false)
	  public void testActionsClass() {
		  WebElement electronics = driver.findElement(By.xpath("//div[@id='ui-id-4']"));
		  WebElement carhifi = driver.findElement(By.xpath("//div[@id='ui-id-6']"));
		  WebElement utilities = driver.findElement(By.xpath("//div[@id='ui-id-7']"));
	  
		  WebElement music = driver.findElement(By.xpath("//div[@id='ui-id-9']"));
		  WebElement rock = driver.findElement(By.xpath("//div[@id='ui-id-10']"));
		  WebElement alternative = driver.findElement(By.xpath("//div[@id='ui-id-11']"));
	  
		  Actions actions = new Actions(driver);
		  actions.moveToElement(electronics)
		  	.pause(Duration.ofSeconds(5))
		  	.moveToElement(carhifi)
		  	.click()
		  	.perform();
		  
		  actions.moveToElement(electronics)
		  	.pause(Duration.ofSeconds(5))
		  	.moveToElement(utilities)
		  	.click()
		  	.perform();
	  
	  }
	  
	  //Web Table Handling Demo
	  @Test(enabled=false)
	  public void testTableDemo() {
		  List <WebElement> rowNum = driver.findElements(By.xpath("//table/tbody/tr"));
		  List <WebElement> columnNum = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
	  
		  System.out.println("Table number of rows: "+ rowNum.size() + " number of columns: "+columnNum.size());
		  for (int i=1; i<=rowNum.size(); i++) {
			  
			  for (int j=1; j<=columnNum.size(); j++) {
				  String txt = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
				  System.out.println("Row-"+i+";Column-"+j+" cell contents: "+ txt);
			  } 
		  }
	  }
	  
	   
	  @Test (enabled=false)
	  public void testDragAndDrop() {
		  WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
		  WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
	  
		  Actions action = new Actions(driver);
		//Perform drag and drop
		  action.dragAndDrop(from, to).perform();
		  //verify text changed in to 'Drop here' box 
		  String textTo = to.getText();
		  if(textTo.equals("Dropped!")) {
		  System.out.println("PASS: File is dropped to target as expected");
		  }else {
		  System.out.println("FAIL: File couldn't be dropped to target as expected");
		  }  
	  
	  }
	  
	  
	  @AfterClass
	  public void afterClass() {
		 //driver.close();
	  }
}

