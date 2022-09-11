package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	@BeforeTest
	public void datasetup() throws IOException
	{
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet1");
		
	}
	
	@AfterTest
	public void datacleanup() throws IOException
	{
		workbook.close();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	
	public void teardown()
	{
		driver.close();
	}
}
