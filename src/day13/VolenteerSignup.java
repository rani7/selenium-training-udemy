package day13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VolenteerSignup {
	
	public static void clickElement(WebElement element, WebDriver driver){
   	 JavascriptExecutor js = ((JavascriptExecutor) driver);
   	 js.executeScript("arguments[0].click();",element);
     }

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://goo.gl/RVdKM9");
		
	
		
		driver.manage().window().maximize(); // Maximize your browser/page
		
		String title=driver.getTitle(); // returns the title of the page
		System.out.println("Title of the page is :"+title);
		
		String url=driver.getCurrentUrl();// returns the URL of the page
		System.out.println("URL of the page is :"+url);
		
		//System.out.println(driver.getPageSource()); // returns HTML code for page
		
		//Firstname
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("John");
		
		//Lastname
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Canedy");
		
		//phone
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("2345789876");
		
		//country
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("Canada");

		//city
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("Toronto");
		
		//email
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("anbdfge@gmail.com");
		
	
		//Handling radio buttons
		//----------------------------
		//Conditional commands
			
		WebElement radmale=driver.findElement(By.id("RESULT_RadioButton-7_0"));	
		
		System.out.println(radmale.isDisplayed()); // check displayed or not - true
		
		System.out.println(radmale.isEnabled()); //checks enable or not - true
		
		System.out.println("Before selecting radio button , the status is:"+radmale.isSelected()); // false
				
		//radmale.click(); // select radio button
		clickElement(radmale,driver);
		
		System.out.println("After selecting radio button , the status is:"+radmale.isSelected()); //true
		
		//Handling check boxes
		//-----------------
		
		//driver.findElement(By.id("RESULT_CheckBox-8_0")).click();//Sunday
		WebElement sunday=driver.findElement(By.id("RESULT_CheckBox-8_0"));
		clickElement(sunday,driver);
		//driver.findElement(By.id("RESULT_CheckBox-8_6")).click(); //Saturday
		WebElement saturday= driver.findElement(By.id("RESULT_CheckBox-8_6"));
		clickElement(saturday,driver);
		
		//Handling Drop down
		//---------------------------
	    //WebElement drp=driver.findElement(By.xpath("//*[@id="RESULT_RadioButton-9"]"));
			
		//Select dropdown=new Select(drp);
				
	      Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']")));
				
						
		// 1)Find how many options present in drop down
		  System.out.println("No of Options present in drop down:" +dropdown.getOptions().size());
				
		//2) Extract all the options and print them
					
		   List <WebElement> options=dropdown.getOptions();
					
		  for(WebElement e:options)
			{
			System.out.println(e.getText());
				}
		//3) Select option from the dropdown 
		//dropdown.selectByVisibleText("Morning");
		//dropdown.selectByIndex(1); //AFTERNOON  --> index starts from 0
		  dropdown.selectByValue("Radio-2"); //EVENING
		
		
		//Text Area
		//---------------
		
		//driver.findElement(By.id("RESULT_TextArea-12")).sendKeys("TESTING");
		
		
		//Handle Links
		
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back(); // go back to your previous page
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Tools Training")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back(); // go back to your previous page
		Thread.sleep(3000);
		
		driver.navigate().forward();//move forward to your page
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh(); //refresh the page
		
		driver.quit();
	}

}








