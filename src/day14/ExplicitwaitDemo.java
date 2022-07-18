package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitwaitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		
		WebDriverWait mywait=new WebDriverWait(driver,2000);
				
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame(0);		
		WebElement fname=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RESULT_TextField-1\"]")));
		
		fname.sendKeys("mercury1");
		
		
		WebElement lname=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RESULT_TextField-2\"]")));
	    lname.sendKeys("mercury2");
		
		driver.close();

	}

}
