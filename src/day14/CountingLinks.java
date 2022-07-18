package day14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountingLinks {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		//driver.manage().window().maximize(); //maximize the page
		
		List <WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
	
		//reading all the links from web page and display
		
		for(WebElement e:links)
		{
			System.out.println(e.getText());
		}
		
		
		driver.close();
		
	}

}
