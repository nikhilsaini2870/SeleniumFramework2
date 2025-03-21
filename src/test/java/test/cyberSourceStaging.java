package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;

public class cyberSourceStaging extends BaseTest {
	
	
	
	  @BeforeTest public void fetchData() throws IOException { Properties
	  properties = new Properties(); FileInputStream fileInput = new
	  FileInputStream(
	  "//home//nsaini//Desktop//Nikhil//NIkh//SeleniumFramework2//src//main//resources//Data1.properties"
	  ); properties.load(fileInput); }
	 

	@Test
	public void deleteCyberSourceSubscriptionStaging() throws InterruptedException
	{
		//driver.get("https://ebc2test.cybersource.com/ebc2/");
		driver.findElement(By.id("orgId")).sendKeys("");
		driver.findElement(By.id("username")).sendKeys("asohi");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Email to')]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[text()='Continue']"));
		driver.get("https://ebc2test.cybersource.com/ebc2/app/VirtualTerminal/RecurringBilling?fromMenu=true");
		int a =1;
		while(a>0) {
		driver.findElement(By.className("vds-checkbox-label")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Reset Search']")).click();
		
		}
		


	}
	
	

}
