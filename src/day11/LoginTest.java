package day11;

//change the website
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); //ChromeDriver driver=new ChromeDriver(); // Invokes the chrome browser
	
		
		driver.get("http://practice.automationtesting.in/"); //Open URL  
		
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.id("username")).sendKeys("pavanoltraining"); //Enter username  
		
		driver.findElement(By.id("password")).sendKeys("Test@selenium123"); //Enter password  
		
		driver.findElement(By.name("login")).click();   //Click on Submit.
		
		Thread.sleep(5000);
		
		String actTitle="pavanoltraining";
		String expTitle=driver.getTitle();
		
		//Verify title of the page
				if(expTitle.contains(actTitle))
				{
					System.out.println("Login test passed");
				}
				else
				{
				System.out.println(" Login Test failed");	
				}
				
		driver.close(); // closes the browser
	}

}
