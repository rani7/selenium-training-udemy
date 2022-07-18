package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver","E://selenium/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="users") // dataProvider a parameter of @Test annotaion
	void logintest(String uname, String pwd)
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.name("Submit")).click();
		//Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	}
	
	@DataProvider(name="users") // @DataProvider is annotation
	String [][] loginData()
	{
		String data[][]={ {"admin","admin123"},{"mer","mer"},{"mercury1","mercury1"}};
		return data;
	}
	
	@AfterClass
	void closeBrowser()
	{
		driver.close();
	}
}
