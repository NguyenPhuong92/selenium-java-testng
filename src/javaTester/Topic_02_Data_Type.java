package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Type {

	public static void main(String[] args) {
		
		//I- Kiểu dữ liệu nguyên thuỷ Primitive)
		
			// Số nguyên: byte short int long (ko có phần thập phân) - kích thước/độ rộng để lưu trữ dữ liệu từ nhỏ đến lớn
		
			// Số thực: float double (có phần thập phân)
			float studentPoint = 9.5f;
					
			double employeeSalary = 35.6d;
			
			// Logic: boolean (true/false)
		
			// Kí tự: char (char a = 'A')
		
		//II- Kiểu dữ liệu tham chiếu (Reference)
			// Class
			FirefoxDriver driver = new FirefoxDriver();
			
			// Interface
			WebElement firstNameTextbox;
			
			// String
			String firstName = "Automation Testing"
					
			// Object
			Object peple;
			
			// Array
			String [] studentName = {"Nguyễn Văn A","Lê Văn Hùng","Trần Thị Bé"};
			
			// Collection: List/ Set/ Queue
			List<WebElement> checkboxes = driver.findElement(By.cssSelector(""));
					
			// Map
			Map<String, Integer> student = new HashMap<String, Integer>();
			

	}

}
