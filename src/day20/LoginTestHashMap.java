package day20;

//change website
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestHashMap {

	
	static HashMap <String,String> logindata()
	{
		HashMap <String,String> hm=new HashMap<String,String>();
		
		hm.put("x", "pavanoltraining@Test@selenium123");
		hm.put("y", "mercury1@mercury1");
		hm.put("z", "mercury2@mercury2");
		
		return hm;
	}
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        driver.get("http://practice.automationtesting.in/"); //Open URL  
		
		driver.findElement(By.linkText("My Account")).click();
		
		String credentials=logindata().get("x");
		
		String uarr[]=credentials.split("@"); // splitting
		
		driver.findElement(By.name("username")).sendKeys(uarr[0]);
		driver.findElement(By.name("password")).sendKeys(uarr[1]);
		driver.findElement(By.name("login")).click();
		
		if (driver.getTitle().contains("Automation")) {
			System.out.println("Test Passed");

		} else {
			System.out.println("Test failed");

		}
		
		driver.close();
		
		
	}

}
