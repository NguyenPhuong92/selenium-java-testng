package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Path {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// Hiện tính năng gợi ý - Suggest code lại: ấn Ctrl Space\
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		// Assert.assertTrue > Kiểm tra 1 điều kiện trả về là đúng
		// Assert.assertFalse > Kiểm tra 1 điều kiện trả về là sai
		// Assert.assertEquals > Kiểm tra thực tế vs mong đợi như nhau
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("EastWind");
		driver.findElement(By.id("txtEmail")).sendKeys("123@abc@fsf");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@abc@fsf");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
	}

	@Test
	public void TC_03_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("EastWind");
		driver.findElement(By.id("txtEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtCEmail")).sendKeys("east@wind.net");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_04_Invalid_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("EastWind");
		driver.findElement(By.id("txtEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtCEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtPassword")).sendKeys("12345");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_05_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.id("txtFirstname")).sendKeys("EastWind");
		driver.findElement(By.id("txtEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtCEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345687");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action1
		driver.findElement(By.id("txtFirstname")).sendKeys("EastWind");
		driver.findElement(By.id("txtEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtCEmail")).sendKeys("east@wind.vn");
		driver.findElement(By.id("txtPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtPhone")).sendKeys("012345678");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify1
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

		//Action2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("12345678");
				
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
		//Verify2
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}