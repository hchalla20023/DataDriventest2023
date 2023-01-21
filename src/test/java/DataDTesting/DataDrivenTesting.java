package DataDTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excel.Xls_Reader;


public class DataDrivenTesting {
	
	public static WebDriver driver;
	
	@Test()
	public void DDTesting() {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\hchalla2020\\TestAutomation\\NewWorkspace2021\\DatadrivenAmazon\\src\\test\\java\\TestData\\Data.xlsx");
		String myurl = reader.getCellData("TestData", "URL", 2);
		
		String myproduct = reader.getCellData("TestData", "AmazonProductName", 2);
		WebDriverManager.chromedriver().setup();
		  //System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Selenium\\Drivers\\chromedriver.exe");
			
			 driver = new ChromeDriver();
			 
			 driver.get(myurl);
			 
			 driver.manage().window().maximize();
			 
			 driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(myproduct);
			 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		      System.out.println("Closing the browser");
			 driver.close();
	}	
}
