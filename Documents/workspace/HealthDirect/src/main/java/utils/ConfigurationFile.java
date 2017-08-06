package utils;

//Configuration class file. It is a static class which contains configuration info such as browser name, home page url.
public class ConfigurationFile {
	
	public static class URL
	{
	//Application URL
		public static String app_url = "https://www.healthdirect.gov.au";
	}
	
	public static class Browser
	{
		//which browser
		public static String browser = "chrome";
		public static String whichpath = "/Users/sankavi/bdriver/chromedriver";
	}
	
	public static class SearchText
	{
		public static String value = "parasite";
	}

}
