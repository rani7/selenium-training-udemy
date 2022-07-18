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
	
		
		driver.get("http://newtours.demoaut.com/"); //Open URL  http://opensource.demo.orangehrmlive.com
		
		driver.findElement(By.name("userName")).sendKeys("mercury"); //Enter username  (Admin).
		
		driver.findElement(By.name("password")).sendKeys("mercury"); //Enter password  (admin).
		
		driver.findElement(By.name("login")).click();   //Click on Submit.
		
		Thread.sleep(5000);
		
		String actTitle="Find a Flight: Mercury Tours:";
		String expTitle=driver.getTitle();
		
		//Verify title of the page
				if(expTitle.equals(actTitle))
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
