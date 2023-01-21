package DataDTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excel.Xls_Reader;

public class ParametrizationTesting {
	
	public static WebDriver driver;
	@Test
	public void parametrization() {
		    WebDriverManager.chromedriver().setup();
		     //System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Selenium\\Drivers\\chromedriver.exe");
			
			 driver = new ChromeDriver();
			 
			 driver.get("https://www.amazon.in/");
			 
			 driver.manage().window().maximize();
			 
			 Xls_Reader reader = new Xls_Reader("C:\\Users\\hchalla2020\\TestAutomation\\NewWorkspace2021\\DatadrivenAmazon\\src\\test\\java\\TestData\\Data.xlsx");
							
				int rowscount = reader.getRowCount("TestData");
				
				System.out.println(rowscount);
				
				for(int rownum =2; rownum<=rowscount; rownum++ ) {
					
					String myurl = reader.getCellData("TestData", "URL",rownum);
					
					String myproduct = reader.getCellData("TestData", "AmazonProductName", rownum);
					
					 driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(myproduct);
					 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

					reader.setCellData("TestData", "Status", rownum, "Passed");
								 
					 driver.close();
		}
	}

}
