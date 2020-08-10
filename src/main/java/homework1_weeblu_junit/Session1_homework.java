package homework1_weeblu_junit;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Session1_homework {

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
		  driver.findElement(By.xpath("//span[contains(text(),'Welcome TechFios')]")).click();
		  Thread.sleep(3000);
              System.out.println(driver.getTitle());
             String Expected="Dashboard- iBilling";
             String Actual=driver.getTitle();
              Assert.assertEquals(Expected, Actual);
              System.out.println("Dashboard is visible");
            driver.findElement(By.xpath("//ul[@class='dropdown-menu animated fadeIn']/li[5]/a")).click();
	}

	
	
	
	
	
}
