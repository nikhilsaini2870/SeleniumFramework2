package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
		{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="(//a[@aria-label='Sign into Gmail'])[2]")
	WebElement signInButton;
	
	@FindBy(id="identifierId")
	WebElement emailOrPhone;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;
	
	
	
	
}
