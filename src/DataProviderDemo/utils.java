package DataProviderDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class utils extends baseDataProver{
		
	public void takeScreenShot() throws IOException  {
		// Take Screenshot for Evidence
		File srce = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File targetfile = new File(System.getProperty("user.dir")+"/Screenshots/"+"ErrorStatus_"+datetime+".png");
		
		System.out.println(targetfile);
		// Save the screenshot in the given path by the name FbStatus.png
		FileUtils.copyFile(srce, targetfile);
		
	}
	
	public Object[][] ReadData() throws IOException {
		
		XSSFWorkbook workbook;
		XSSFSheet worksheet;
		DataFormatter formatter= new DataFormatter();
		String file_location = System.getProperty("user.dir")+"//src//DataProviderDemo/inputdata.xls";
		String SheetName= "Sheet1";
		String Res;
		
	 FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
	 workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	 worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
	 XSSFRow Row=worksheet.getRow(0);   //get my Row which start from 0   
	   
	 int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	 int ColNum= Row.getLastCellNum(); // get last ColNum 
	 System.out.println("row: "+RowNum + " colum: "+ColNum);
	 
	 Object Data[][]= new Object[RowNum][ColNum]; // pass my  count data in array
	     
	 for(int i=0; i<RowNum; i++) //Loop work for Rows
	 {  
		 XSSFRow row= worksheet.getRow(i);
	     
	     for (int j=0; j<ColNum; j++) //Loop work for colNum
	     {
	    	if(row==null)
	    		Data[i][j]= "";
	    	else 
	    	{
	    		XSSFCell cell= row.getCell(j);
	    		if(cell==null)
	    			Data[i][j]= ""; //if it get Null value it pass no data 
	    		else
	    		{
	    			String value=formatter.formatCellValue(cell);
	    			System.out.println("row is : "+row + " cell is : "+cell+"value is: "+value);
	    			Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	    		}
	    	}
	     }
	 }
	 workbook.close();
	 return Data;
   }
	
	public Object[][] mySqlData() throws SQLException {
		Object data[][] = null;
		// Connection object
		Connection con = null;
		// Statement object
		Statement stmt = null;
		// Constant for Database URL
		String DB_URL = "jdbc:mysql://localhost:3306/employee_system";
		//Database Username
		String DB_USER = "root";
		// Database Password
		String DB_PASSWORD = "root";
		
		try {
			// Database connection
			String dbClass = "com.mysql.cj.jdbc.Driver";
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName(dbClass).newInstance();
			// Get connection to DB
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try{
			String query = "select * from employees";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			
			//Moving the cursor to the last row
		     res.last();
		     int rowNum = res.getRow();
		     
		   //Retrieving the ResultSetMetaData object
		     ResultSetMetaData rsmd = res.getMetaData();
		     //getting the column type
		     int colNum = rsmd.getColumnCount();
		     
		     System.out.println("Table contains "+rowNum+" rows And "+ colNum+ " Columns");
		     // allocate memory for the 2D array object
		     Object Data[][]= new Object[rowNum][colNum];
		     
		     res.beforeFirst();			
		     // Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			int i=0;
		     while (res.next())
			{
		    	Data[i][0]= res.getString("id");
		    	Data[i][1]= res.getString("email");
		    	Data[i][2]= res.getString("first_name");
		    	Data[i][3]= res.getString("last_name");
		    	
				/*System.out.print(Data[i][0]);
				System.out.print(" " + Data[i][1]);
				System.out.print(" " + Data[i][2]);
				System.out.println(" " + Data[i][3]);*/
				
				i = i+1;
			}
		    data = Data;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	
}
