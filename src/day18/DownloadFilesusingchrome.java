package day18;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadFilesusingchrome {

	public static void main(String[] args) throws InterruptedException {
	
		
		//download files in required location using chrome
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", "false");
		chromePrefs.put("download.default_directory","D:\\Downloadedfiles"); //configure path

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		options.setExperimentalOption("prefs", chromePrefs);
		cap.setCapability(ChromeOptions.CAPABILITY, options);  // end of code
		
		
				
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		driver.manage().window().maximize();
		
		//download text file
		driver.findElement(By.id("textbox")).sendKeys("testing txt file download");
		WebElement generateBtn=driver.findElement(By.id("createTxt"));
		clickElement(generateBtn,driver);
		WebElement downloadBtn=driver.findElement(By.id("link-to-download"));
		clickElement(downloadBtn,driver);
		
		Thread.sleep(5000);
		
		if(isFileExist("E://selenium//Downloadedfiles/info.txt"))
		{
			System.out.println(" file exists");
		}
		else
		{
			System.out.println("file not exists");
		}
		
		//download pdf file
		driver.findElement(By.id("pdfbox")).sendKeys("testing pdf downlaod");
		WebElement generateBtn2=driver.findElement(By.id("createPdf"));
		clickElement(generateBtn2,driver);
		WebElement downloadBtn2=driver.findElement(By.id("pdf-link-to-download"));
		clickElement(downloadBtn2,driver);
		
		Thread.sleep(5000);
		
		if(isFileExist("E://selenium//Downloadedfiles/info.pdf"))
		{
			System.out.println(" file exists");
		}
		else
		{
			System.out.println("file not exists");
		}
		
	}

	
	static boolean isFileExist(String path)
	{
		File f=new File(path);
		
		if(f.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void clickElement(WebElement element, WebDriver driver){
	   	 JavascriptExecutor js = ((JavascriptExecutor) driver);
	   	 js.executeScript("arguments[0].click();",element);
	     }
	
}
