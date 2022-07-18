package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();// maximize the page
		
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click(); //ClickMe button
		
		Thread.sleep(5000);
		
		//driver.switchTo().alert().accept();//closes popup by using OK button
		driver.switchTo().alert().dismiss();//closes popup by using Cancel button
		
		driver.close();
	}

}
