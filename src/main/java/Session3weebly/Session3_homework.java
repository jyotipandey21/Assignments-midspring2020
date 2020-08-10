package Session3weebly;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;





public class Session3_homework {

	WebDriver driver;

	@Before
	public void open() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void Transactions() throws InterruptedException {
		driver.findElement(By.xpath("// span[contains(text(),'Transactions')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Transfer')]")).click();
		Thread.sleep(2000);
		Select sel=new Select(driver.findElement(By.xpath("//select[@id='faccount']")));
		sel.selectByVisibleText("3088");
		//sel.selectByValue("4");
		
		driver.findElement(By.xpath("//a[contains(text(),'New Expense')]")).click();
		
		Select sel2=new Select(driver.findElement(By.xpath("//select[@id='account']")));
		sel2.selectByVisibleText("3373");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Transfer')]")).click();                               //a[contains(text(),'Transfer')]
		Thread.sleep(2000);
		
		Select sel3=new Select(driver.findElement(By.xpath("//select[@id='faccount']")));
		sel3.selectByVisibleText("5639");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'View Transactions')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Balance Sheet')]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Balance Sheet')]")).click();
		//driver.findElement(By.xpath("//tbody/tr[2]/td[contains(text(),'rforty4567856799')]"))).getText();
		//tbody/tr[2]/td[1]
		
		String before_path="//tbody/tr[";
		String after_path="]/td[1]";
		for(int i=2;i<=5;i++) {
		String Account=driver.findElement(By.xpath( before_path +i+ after_path)).getText();	
		if(Account.contentEquals(Account)) {
			System.out.println("Account created");
		}
		}
		//old site work//
/*		Select sel1=new Select(driver.findElement(By.xpath("//select[@id='taccount']")));
		sel1.selectByVisibleText("Mean885");
//	driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Deposit");	
//	driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("5000");
//	driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Jyoti enjoy gift");	
//	driver.findElement(By.xpath("//button[@id='submit']")).click();
	
	//a[contains(text(),'New Expense')]
*/
	}	
}
