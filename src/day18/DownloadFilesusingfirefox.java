package day18;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFilesusingfirefox {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxProfile profile=new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf"); // set Mime type according to your file format
		profile.setPreference("browser.download.manager.showWhenStarting", false);
				
		//download files in desired location
		profile.setPreference("browser.download.dir","E:\\DownloadedFiles");
		profile.setPreference("browser.download.folderList", 2); 
		profile.setPreference("pdfjs.disabled", true); // only for pdf file
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
				
		
		System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(option);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		driver.manage().window().maximize();
		
		//download text file
		driver.findElement(By.id("textbox")).sendKeys("testing txt file download");
		WebElement crtTxt=driver.findElement(By.id("createTxt"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", crtTxt);
		WebElement dwlink=driver.findElement(By.id("link-to-download"));
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", dwlink);
		
		Thread.sleep(5000);
		
		if(isFileExist("E://DownloadedFiles/info.txt"))
		{
			System.out.println(" file exists");
		}
		else
		{
			System.out.println("file not exists");
		}
		
		//download pdf file
		driver.findElement(By.id("pdfbox")).sendKeys("testing pdf downlaod");
		WebElement crtPdf=driver.findElement(By.id("createPdf"));
		JavascriptExecutor js3 = (JavascriptExecutor)driver;
		js3.executeScript("arguments[0].click();", crtPdf);
		WebElement dwPdflink=driver.findElement(By.id("pdf-link-to-download"));
		JavascriptExecutor js4 = (JavascriptExecutor)driver;
		js4.executeScript("arguments[0].click();", dwPdflink);
		
		Thread.sleep(5000);
		
		if(isFileExist("E://DownloadedFiles/info.pdf"))
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
	
	
	
}
