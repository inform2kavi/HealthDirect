package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigurationFile;


//Singleton class. To make sure single driver exists
public class DriverClass {		
				
				//Declaring Instance of WebDriver
				public static WebDriver Instance;
				
				public static WebDriver Initialize(WebDriver driver) throws IOException

				{
					Instance = driver;
					//Instantiating the corresponding browser by reading the browser name from configuration file
					if(Instance==null)
					{
						System.out.println("Initiating Driver");
						
						if(ConfigurationFile.Browser.browser.equalsIgnoreCase("firefox"))
						{
							//Initializing firefox browser
							return Instance;
						}
						
						else if(ConfigurationFile.Browser.browser.equalsIgnoreCase("chrome"))
						{
							//Initializing chrome browser
							System.setProperty("webdriver.chrome.driver", ConfigurationFile.Browser.whichpath);
							Instance = new ChromeDriver();
							return Instance;
						}
						
						else
						{
							System.out.println("Initializing driver browser");
							return Instance;
						}
					}
					
					else
					{
						System.out.println("Browser already instantiated");
						return driver;
					}
					
				}
				
				public static void maximize()
				{
					Instance.manage().window().maximize();
				}
				
				public static void quit()
				{
					Instance.quit();
					Instance = null;
				}
				
				public static void close()
				{
					Instance.close();
					Instance = null;
				}
				
		}
	


