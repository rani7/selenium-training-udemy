package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalculator {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		driver.manage().window().maximize();
		
		String path="E://selenium/caldata.xlsx";
		
		XLUtils.setExcelFile(path, "Sheet1");
		
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		
		
		for(int i=1;i<=rowcount;i++)
		{
			
			int princ=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 0));
			int rateofinterest= Integer.parseInt(XLUtils.getCellData(path,"Sheet1",i, 1));
			int per= Integer.parseInt(XLUtils.getCellData(path,"Sheet1",i, 2));
			String fre=XLUtils.getCellData(path, "Sheet1", i,3);
			double exp_mvalue=Double.parseDouble(XLUtils.getCellData(path,"Sheet1",i,4));
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			
			Select perioddrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perioddrp.selectByVisibleText("year(s)");
			
			Select frequency=new Select(driver.findElement(By.id("frequency")));
			frequency.selectByVisibleText(fre);
			
			WebElement calBtn=driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img"));
			clickfunc(calBtn,driver);
			
			String act_mvalue=driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			
			if(exp_mvalue==Double.parseDouble(act_mvalue))
			{
				System.out.println("test passed");
			}
			else
			{
				System.out.println("test failed");
			}
			
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click(); // clear button
			
			Thread.sleep(3000);
		}
		
	}
	public static void clickfunc(WebElement element, WebDriver driver){
   	 JavascriptExecutor js = ((JavascriptExecutor) driver);
   	 js.executeScript("arguments[0].click();",element);
     }
   

}
