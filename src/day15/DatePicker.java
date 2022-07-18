package day15;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//String year="2018";
		String month="January";
		String date="25";
		
		driver.findElement(By.id("datepicker")).click();//Click on date picker element
		
		//selectCurrentDate();
		//selectFutureDate(date,month);
		selectPastDate(date,month);
	}

	
	static void selectCurrentDate()
	{
		Calendar cal=Calendar.getInstance();
		
		int d=cal.get(Calendar.DATE); // return the current date in int format
		String date=String.valueOf(d); //convert int to string
		
		driver.findElement(By.linkText(date)).click();
	}
	
		
	static void selectFutureDate(String d,String m)
	{
		
		Calendar cal=Calendar.getInstance();
		
		int currentmonth=cal.get(Calendar.MONTH); // return the current month in int format
		
		for(int i=currentmonth;i>=1;i++)
		{
			
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();//Next arrow
			
			String mon=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
			
			
			if(mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				break;
			}
		}
	}
	
	
	static void selectPastDate(String d,String m)
	{
		
		Calendar cal=Calendar.getInstance();
		
		int currentmonth=cal.get(Calendar.MONTH); // return the current month in int format
		
		for(int i=currentmonth;i>=1;i--)
		{
			
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();//Prev arrow
			
			String mon=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
			
			if(mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				break;
			}
		}
	}
	
	
}






