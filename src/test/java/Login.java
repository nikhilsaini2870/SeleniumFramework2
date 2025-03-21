import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;

public class Login extends BaseTest{
	
	@BeforeTest
	public void fetchData() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fileInput = new FileInputStream("//home//nsaini//eclipse-workspace//SeleniumFramework2//src//main//resources//Data1.properties");		
		properties.load(fileInput);
	}

	@Test
	public void Login1()
	{
	System.out.println("Hi");
	int a=1;
	int b=0;
	int c= a/b;
	}
	
}
