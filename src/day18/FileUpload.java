package day18;
//not working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class FileUpload {

	public static void main(String[] args) throws InterruptedException, FindFailed{
		
		DesiredCapabilities desCap=DesiredCapabilities.chrome();
		desCap.acceptInsecureCerts();
		desCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ChromeOptions chromeOpt=new ChromeOptions();
		chromeOpt.merge(desCap);
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(chromeOpt);
		 
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='imagesrc' and @type='file']")).click(); //not working in this step
		
		System.out.println("here");
		String imagesFilepath="E:\\selenium\\orangescreens\\";
		String inputFilepath="E:\\selenium\\orangescreens\\inputfile\\";
		
		Screen s = new Screen();
		 
	    Pattern fileInputTextBox = new Pattern(imagesFilepath + "FileTextBox.PNG");
	    Pattern openButton = new Pattern(imagesFilepath + "OpenButton.PNG");
		
		Thread.sleep(5000);
		
		s.wait(fileInputTextBox, 20);
		s.type(fileInputTextBox,inputFilepath+"apple.jpg");
		s.click(openButton);
		
	}
	

}


