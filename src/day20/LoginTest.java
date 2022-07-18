package day20;

//change website
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		String path="E://selenium/Login1.xlsx";
		
		int rows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
		String username=XLUtils.getCellData(path,"Sheet1",i, 0);
		String password=XLUtils.getCellData(path, "Sheet1",i, 1);
		
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("login")).click();
		
		if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
		{
			System.out.println(" test passed");
			XLUtils.setCellData(path,"Sheet1", i, 2, "Passed");
			
		}
		else
		{
			System.out.println(" test failed");
			XLUtils.setCellData(path,"Sheet1", i, 2, "Failed");
		}
		
		driver.findElement(By.linkText("Home")).click();
		}
		
		driver.close();
	}

}
