package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//int rows=driver.findElements(By.tagName("tr")).size();
		
		int rows=driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr")).size();
		
		System.out.println(rows);
		
		int columns=driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[1]/th")).size();
		System.out.println(columns);
		
		System.out.println("Bookname"+"         "+"Author"+"           "+"Subject"+"          "+"Price");
		
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=columns;c++)
			{
				
				String value=driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+"       ");
				
			}
			System.out.println();
		}
		
		driver.close();
	}
}
