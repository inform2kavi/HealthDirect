package healthdirect;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationFile;
import pages.HomePageObject;

public class SearchTest extends Baseclass{
	
	@Test
	public void VerifySearch()
	{	
		//Creating object of page class
		HomePageObject objpage = new HomePageObject();
		
		//Navigating to homepage URL www.healthdirect.gov.au
		driver.navigate().to(ConfigurationFile.URL.app_url);
		
		//Asserting whether search text present in the returned search page title
		//Assert.assertEquals(ConfigurationFile.SearchText.value, objpage.verifySearchResult(driver,ConfigurationFile.SearchText.value));
		String result = objpage.verifySearchResult(driver,ConfigurationFile.SearchText.value);
		Assert.assertEquals("Matched", result);	
	}

}
