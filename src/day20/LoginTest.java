package day20;

//not working
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://practice.automationtesting.in/");
		driver.findElement(By.linkText("My Account")).click();
		
		String path="E://selenium/Login1.xlsx";
		
		int rows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
		String username=XLUtils.getCellData(path,"Sheet1",i, 0);
		String password=XLUtils.getCellData(path, "Sheet1",i, 1);
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("login")).click();
		WebElement wb=driver.findElement(By.linkText("Sign out"));
		
		if(wb.isDisplayed())
		{
			System.out.println(" test passed");
			XLUtils.setCellData(path,"Sheet1", i, 2, "Passed");
			wb.click();
		}
		else
		{
			System.out.println(" test failed");
			XLUtils.setCellData(path,"Sheet1", i, 2, "Failed");
		}
		
		}
		
		driver.close();
	}

}
