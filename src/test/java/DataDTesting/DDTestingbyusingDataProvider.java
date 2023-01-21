package DataDTesting;

import java.util.ArrayList;
import java.util.Iterator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTestingbyusingDataProvider {
	
WebDriver driver;

@BeforeMethod	
public void startup() {
        WebDriverManager.chromedriver().setup();
	     //System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Selenium\\Drivers\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.amazon.in/");
   }

    @DataProvider
    public Iterator<Object[]> getdata() {
    	
    	ArrayList<Object[]> dataaa = Utility.getdatafromexcel();
    	
    	return dataaa.iterator();
    }
    
    @Test(dataProvider="getdata", priority=1)
    public void amzonproductsearch(String prd) {
    	
    	 driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(prd);
		 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
    }
    
    @AfterMethod
    public void closebrowser() {
    	
    	driver.close();
    }
}
