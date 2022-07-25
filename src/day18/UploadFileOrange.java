package day18;

//not working
import org.openqa.selenium.By;                
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class UploadFileOrange {

	public static void main(String args[]) throws InterruptedException, FindFailed
		{
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		
		driver.findElement(By.name("Submit")).click();
		WebElement PIM=driver.findElement(By.xpath("//*[@id=\'menu_pim_viewPimModule\']/b"));
		WebElement Employeelist=driver.findElement(By.id("menu_pim_viewEmployeeList"));
		
		WebElement addEployee=driver.findElement(By.xpath("//*[@id=\'menu_pim_addEmployee\']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(PIM).moveToElement(Employeelist).moveToElement(addEployee).click().build().perform();
		
		
		driver.findElement(By.xpath("//*[@id=\'photofile\']")).click();
				
		String imagesFilepath="E:\\selenium\\orangescreens\\";
		String inputFilepath="E:\\selenium\\orangescreens\\inputfile\\";
		
		Screen s=new Screen();
		
		Pattern fileInputTextBox=new Pattern(imagesFilepath + "Filetxtbox.PNG");
		Pattern openButton=new Pattern(imagesFilepath + "openbtn.PNG");
		
			
		s.wait(fileInputTextBox,10);
		s.type(fileInputTextBox,inputFilepath +"apple.jpg");
		s.click(openButton);
			
		

	}

}
