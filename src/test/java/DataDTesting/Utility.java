package DataDTesting;

import java.util.ArrayList;

import excel.Xls_Reader;

public class Utility {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getdatafromexcel() {
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		try {
			
			reader = new Xls_Reader("C:\\Users\\hchalla2020\\TestAutomation\\NewWorkspace2021\\DatadrivenAmazon\\src\\test\\java\\TestData\\Data.xlsx");
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		for(int rownum = 2; rownum<=reader.getRowCount("TestData"); rownum++) {
			
			//String myurl = reader.getCellData("TestData", "URL", rownum);
			
			String myproduct = reader.getCellData("TestData", "AmazonProductName", rownum);
			
			Object ob[] = {myproduct};
			
			mydata.add(ob);
		}
		
		return mydata;
	}
}
