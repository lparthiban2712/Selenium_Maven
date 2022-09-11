package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage{

WebDriver driver;

@FindBy(linkText="Log in")
WebElement signin;

@FindBy(name="user_login")
WebElement email;

@FindBy(id="password")
WebElement password;


@FindBy(className="rememberMe")
WebElement remember;


@FindBy(name="btn_login")
WebElement login;

public  Loginpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	public void Login(String username, String pass)
	{
		signin.click();
		email.sendKeys(username);
		password.sendKeys(pass);
		remember.click();
		login.click();
	}
}
