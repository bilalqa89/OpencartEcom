package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountregistrationObject extends BasePage {
	
	public AccountregistrationObject (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtPhoneno;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement txtConfirmPassword;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement newsletter ;
	@FindBy(xpath="//input[@name='agree']") WebElement chkboxpolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnregister;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation ;
	
	public void setfirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
		
	}
	
	public void setlastname(String lname)
	{
		txtLastname.sendKeys(lname);	
	}
	public void setemail(String email)
	{
		txtEmail.sendKeys(email);	
	}
	public void setphoneno(String tel)
	{
		txtPhoneno.sendKeys(tel);	
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void confirmpassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickcheckbox()
	{
		newsletter.click();
	}
	public void checkpolicy()
	{
		chkboxpolicy.click();
	}
	
	public void btnregister()
	{
		btnregister.click(); 
	
	}
	
	public String confirmationmsg()
	{
		try {
			return(msgConfirmation.getText());
			
		}
		
		catch(Exception e)
		{
			return(e.getMessage());
			
		}
	}
	

}
