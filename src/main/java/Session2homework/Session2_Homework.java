package Session2homework;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Session2_Homework {

WebDriver driver;
	
	@Before

	public void open() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test()
	  public void user () throws InterruptedException {
		 driver.findElement(By.name("username")).sendKeys("demo@techfios.com");
		  driver.findElement(By.id("password")).sendKeys("abc123");
		  driver.findElement(By.name("login")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
		 // Thread.sleep(2000);
            driver.findElement(By.xpath("//a[contains(text(),'New Deposit')]")).click(); 
               Thread.sleep(2000);
            driver.findElement(By.xpath("//select[@id='account']")).click();
            
          Select sel = new Select(driver.findElement(By.xpath("//select[@id='account']")));
         sel.selectByVisibleText("Mean680");
	}
}
	
	
	
//select[@id='account']
	


	

