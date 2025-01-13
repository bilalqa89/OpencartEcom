package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtocCart extends BasePage {

	public AddtocCart(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Phones & PDAs')]")
	WebElement linkphonepda;
	
	@FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//span[1]")
	WebElement linkaddtocart;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement linkshowcart;
	
	public void clickmenu()
	{
		linkphonepda.click();
	}
	public void clickaddtocart()
	{
		linkaddtocart.click();
	}
	public void clickshowcart()
	{
		linkshowcart.click();
	}
	
	
}
