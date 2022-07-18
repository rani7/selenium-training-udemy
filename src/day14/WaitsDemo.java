package day14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // implicit wait
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("abc");
	}

}
