package healthdirect;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.DriverClass;

public class Baseclass {
	WebDriver driver;
	
	//before class method to initialize the driver
	@BeforeClass
	public void setup() throws IOException
	{
		//System.out.println("beforeclass");
		this.driver = DriverClass.Initialize(driver);
	}
	
	//after class method to close the driver
	@AfterClass
	public void close()
	{
		DriverClass.close();
	}

}
