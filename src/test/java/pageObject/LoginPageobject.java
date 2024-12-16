package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageobject extends BasePage {

	public LoginPageobject (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtemail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	@FindBy(xpath="//a[normalize-space()='Forgotten Password']")
	WebElement btnforgetpassword;
	
	
	public void setuseremail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickloginbuttion()
	{
		btnlogin.click();
	}
	public void clickforgetpassword()
	{
		btnforgetpassword.click();
	}

}
