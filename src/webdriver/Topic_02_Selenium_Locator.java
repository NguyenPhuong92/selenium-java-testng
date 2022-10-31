package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Mở trang Register
		driver.get("https://demo.nopcommerce.com/register");
	}

	public void TC_01_ID() {
		// Thao tác lên Element nào thì phải tìm được element đó: findElement
		// Find theo cái gì: id/ class/ name/ css/ xpath/...
		// Find tìm thấy element rồi thì action lên element đó: click. sendkey (nhập text vào element)...
		
		driver.findElement(By.id("FirstName")).sendKeys("EastWind");
	}

	public void TC_02_Class() {
		driver.get("https://demo.nopcommerce.com/search");
		
		driver.findElement(By.className("search-text")).sendKeys("Iphone");
	}

	public void TC_03_Name() {
		// Click vào Advanced search checkbox
		driver.findElement(By.name("advs")).click();
	}

	public void TC_04_TagName() {
		// Tìm bao nhiêu thẻ input trên màn hình hiện tại
		System.out.println(driver.findElements(By.tagName("input")).size());
	}
	
	public void TC_05_Linktext() {
		// Click vào đường link Addresses (tuyệt đối)
		driver.findElement(By.linkText("Addresses")).click();
	}
	
	public void TC_06_PartialLinktext() {
		// Click vào đường link Addresses (tương đối)
		driver.findElement(By.partialLinkText("vendor account")).click();	
	}
	
	public void TC_07_CSS() {
		// Mở lại trang Register
		driver.get("https://demo.nopcommerce.com/register");	
		
		// cách 1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
		
		// cách 2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locatoer");

		// cách 3
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("Automation@gmail.com");
	}
	
	public void TC_08_XPath() {
		// Mở lại trang Register
		driver.get("https://demo.nopcommerce.com/register");	
				
		// cách 1
		driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Selenium");
				
		// cách 2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");

		// cách 3
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("Automation@gmail.com");
	}
	
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}