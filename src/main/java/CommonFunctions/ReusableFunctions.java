package CommonFunctions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {
	
	WebDriver driver;
	public ReusableFunctions(WebDriver driver) {
		this.driver= driver;
	}

	public void waitElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void moveToChildWindow() {
		//String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator IT = windowHandles.iterator();
		//String parentID = (String) IT.next();
		String childID = (String) IT.next();
		driver.switchTo().window(childID);
		//String title = driver.getTitle();
	}

	
	public List<WebElement> getDataFromDropDownList(By getDropDownData, String userData, WebElement dropDownValueToBeSelected)
	{
	List<WebElement> lists = driver.findElements(getDropDownData);
	

	for (int j = 0; j < lists.size(); j++) 
	{
		String DropDownListData = lists.get(j).getText();
		if (DropDownListData == userData);
		dropDownValueToBeSelected.click();
		break;
	}
	return lists;
	}
	
}
