package day16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableRediff {

	public static void main(String args[]){
		
		int rows_count,col_count;
		String cellText = null;
		
		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa?");
		
		driver.manage().window().maximize();
		
		//Identify the table
		WebElement Table = driver.findElement(By.ByClassName.className("dataTable"));
		
		//Read specific cell value
		WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
		System.out.println("Data for Row 2 and Column 3 is "+cell.getText()+".");
		
		//Fetch Number of of rows in a table
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		rows_count = rows.size();
		
		//Iterate through the rows
		for(int i= 0; i<rows_count; i++){
			//Fetch # of columns in a row
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			col_count = columns.size();
			
			//Iterate through the columns within particular row
			for(int j=0; j<col_count; j++){
				cellText = columns.get(j).getText();
				System.out.print(cellText+"  ");
			}
			System.out.println("");
		}
	}
}