package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Loginpage;

public class SimplilearnLoginTest extends Baseclass{
	
	@Test
	public void Test1()
	{
		test.log(LogStatus.INFO, "Test1 started");
		Loginpage lp=new Loginpage(driver);
		lp.Login("correctusername", "correctpassword");
		WebElement error=driver.findElement(By.id("error_box"));

		String Actual=error.getText();
		String Expected="Please enter a valid email address.";
		
		//Assert.assertEquals(Expected, Actual);
		Assert.assertTrue(error.isDisplayed());
		

	}
	
	@Test
	@Parameters({"email","pwd"})
	public void Test2(String uname, String passwd)
	{
		test.log(LogStatus.INFO, "Test2 started");
		Loginpage lp=new Loginpage(driver);
		lp.Login(uname, passwd);
		

	}
	
	
	@Test
	public void Test3()
	{
		
		test.log(LogStatus.INFO, "Test3 started");
		String uname=sheet.getRow(1).getCell(0).getStringCellValue();
		String passwd=sheet.getRow(1).getCell(1).getStringCellValue();
		Loginpage lp=new Loginpage(driver);
		lp.Login(uname, passwd);
		

	}
}
