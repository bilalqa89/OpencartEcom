package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct extends BasePage {
	
	public SearchProduct(WebDriver driver) {
		super(driver);
		
	}
	
	//locator
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtsearch ;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchbtn ;
	@FindBy(xpath="//i[@class='fa fa-home']")
	WebElement homebutton ;
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']")
	WebElement searchproductfind ;
	
	//action
	public void searchproduct(String sp)
	{
		txtsearch.sendKeys(sp);
	}
	
	public void btnclick()
	{
		searchbtn.click();
	}
	public void clickhomebtn()
	{
		homebutton.click();
	}
	
	public boolean findproductexist()
	{
		try
		{
			return (searchproductfind.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

}
