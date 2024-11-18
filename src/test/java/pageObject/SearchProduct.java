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
	
	
	//action
	public void searchproduct(String sp)
	{
		txtsearch.sendKeys(sp);
	}
	
	public void btnclick()
	{
		searchbtn.click();
	}
	
	

}