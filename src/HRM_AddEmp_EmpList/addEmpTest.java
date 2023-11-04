package HRM_AddEmp_EmpList;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class addEmpTest extends baseDP{
	private static String dataPath = System.getProperty ("user.dir") + "//src//HRM_AddEmp_EmpList/empdetails.xls";
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	private loginPage lp;
	private dashboardPage dp;
	private empListPage elp;
	private addEmpPage addEmpPage;
	private EmpDetailPage edp;
	private static Object[][] EmpData;
	private int row=0;
	@BeforeClass
	public void setUp() throws InterruptedException {
		baseSetup("chrome", url);
		Thread.sleep(3000);
		lp = new loginPage();
	}
	
	@Test(priority=0)
	public void testLogin() throws InterruptedException {
		dp = lp.login("Admin", "admin123");
	}
	
	@Test(priority=1)
	public void testClickPIM() throws InterruptedException {
		elp = dp.clickPIM();
		addEmpPage = elp.clickAddEmpTab();
	}
	
	@DataProvider(name = "Emp-testdata")
  	public static Object[][] excelData() throws IOException{
		String filePath = System.getProperty("user.dir")+"//src//HRM_AddEmp_EmpList/empdetails.xls";
		Object[][] data = new utils().ReadData(dataPath);
		EmpData = data;
		return data;
	}
	
	
	@Test(priority=2, dataProvider="Emp-testdata")
	public void testClickAddEmp(String fn, String ln,String empid) throws InterruptedException {
		addEmpPage = elp.clickAddEmpTab();
		edp = addEmpPage.saveEmp(fn, ln);
		System.out.println("employee id is :" + addEmpPage.getEmpId());	
		EmpData[row][2]= addEmpPage.getEmpId();
		row=row+1;
		addEmpPage = edp.clickAddEmpTab();
	}
	
	@Test(priority=3)
	public void writeData() throws IOException {
		String filePath = System.getProperty("user.dir")+"//src//HRM_AddEmp_EmpList/empdetails.xls";
		new utils().writeData(EmpData,filePath);
	}
	
	@AfterClass
	public void tearDown() {
		//getDriver().quit();
	}

}
