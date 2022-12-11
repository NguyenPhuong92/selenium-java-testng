package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.Name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// Tương tác với Browser sẽ thông qua biến WebDriver driver
		// Tương tác với Element sẽ thông qua biến WebElement element
	
	}

	@Test
	public void TC_01_() {
		// Có nhiều hơn 2 cửa sổ sẽ đóng tab/ window mà nó đang đứng
		driver.close();
				
		// Ko quan tâm có bao nhiêu tab/ window > đóng toàn bộ
		driver.quit(); // hay dùng
		
		
		// Mở ra 1 Url nào đó
		driver.get("https://www.facebook.com/"); //hay dùng
		
		// Click vào link: Tiếng Việt
		
		// Lấy dữ liệu ra, Trả về Url của page hiện tại, thường là getxxxx
				
		Assert.assertEquals(driver.getCurrentUrl(), "https://vi-vn.facebook.com/");
		
		// Trả về Source Code HTML của page hiện tại
		// Verify tương đối
		driver.getPageSource();
		
		Assert.assertTrue(driver.getPageSource().contains("Đăng nhập gần đây"));
		Assert.assertTrue(driver.getPageSource().contains("gần đây"));
		
		// Trả về title của page hiện tại
		driver.getTitle();
		
		Assert.assertTrue(driver.getTitle().contains("Facebook - Đăng nhập hoặc đăng ký"));
		
		// Lấy ra được ID của Window/ Tab mà driver đang đứng (active)
		String loginWindowID = driver.getWindowHandle(); // ít dùng
		
		// Lấy ra ID của tất cả Window/ Tab
		Set<String> allIDs = driver.getWindowHandles(); // ít dùng
		
		// Cookie/ Cache
		Options opt = driver.manage();
		
		// Login thành công > Lưu lại
		opt.getCookies();
		
		// Testcase khác > Set coolkie vào lại > Ko cần phải login nữa
		
		Timeouts time = opt.timeouts();
		
		// Khoảng thời gian chờ elemet xuất hiện
		time.implicitlyWait(5, TimeUnit.SECONDS); // dùng nhiều
		
		// Khoảng thời gian chờ page load xong
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		
		// Khoảng thời gian chờ script được thực thi xong trong vòng x giây
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		Window win = opt.window();
		win.fullscreen();
		win.maximize(); // hay dùng
		
		// Test GUI: Font/ Size/ Color/ Posii=tion/ Location/ ...
		win.getPosition();
		win.getSize();
		
		Navigation nav = driver.navigate();
		nav.back();
		nav.forward();
		nav.refresh();
		
		nav.to("https://vi-vn.facebook.com/"); // giống get nhưng nav support tốt hơn cho nav...
		
		TargetLocator tar = driver.switchTo();
		tar.alert();
		tar.frame("");
		tar.window("");
		
		// Có thể lưu nó vào 1 biến để sử dụng cho các step sau > nếu biến có thể dùng lại nhiều lần
		// Clean code
		WebElement emailTextbox = driver.findElement(By.xpath(""));
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		
		// Nếu ko dùng biến sẽ phải lặp lại code như dưới
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		

		driver.findElements(By.xpath(""));
		
		// Có thể sử dụng luôn (ko cần tạo biến)
		driver.findElement(By.xpath("//button[@id='login']")).click();
		
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}