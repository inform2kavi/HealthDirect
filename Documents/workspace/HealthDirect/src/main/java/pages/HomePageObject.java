package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageObject {
	
	WebDriver driver;
	
	//Locators using xpath
	String search_textbox_locator = "//form[@id='search-form-node-desktop-mode']/input[@id='header-search']";
	String search_result_locator = "//main[@class = 'main_content-article-text']/header/h1";
	String search_noresult_locator = "//div[@class = 'main_content-generic-text']/header/h1";
	String search_result_item_locator = "//a[@class='main_content-search-tile veyron-local-result-item']";
	String search_title = "";
	
	//By objects of the locators
	By search_textbox = By.xpath(search_textbox_locator);
	By search_result = By.xpath(search_result_locator);
	By search_result_items = By.xpath(search_result_item_locator);
	By search_noresult = By.xpath(search_noresult_locator);
	
	//Search for the text and return the value present in the search title of the result page
	public String verifySearchResult(WebDriver driver, String searchText)
	{
		//intializing driver
		this.driver = driver;
		
		String result = "";
		
		//calling the method search
		search(searchText);
		
		//Locating the search title of the page and returning the text
		try
		{
			result = driver.findElement(search_result).getText();
		
			List <WebElement> WE_Result_Items = driver.findElements(search_result_items);
		
			Boolean isSearchMatched = false;
		
			for (WebElement WE:WE_Result_Items)	
			{
				if (!WE.findElement(By.xpath(".//h4")).getText().contains(searchText))
					if (WE.findElement(By.xpath(".//p")).getText().contains(searchText))
						isSearchMatched = true;
				else
					isSearchMatched = true;
						
			}
		
			System.out.println(WE_Result_Items.size() + " " + result.replace(":", "") + " found on the homepage");
		
			//Splitting using the regex " and returning the second part of the string
			//return result.split("\"")[1];
			if (isSearchMatched)
				result = "Matched";
			else
				result = "Not Matched";
		}
		catch(Exception e)
		{
			result = driver.findElement(search_noresult).getText();
			if (result.contains("No search result"))
			{
				System.out.println("No search result found for the search text : " + searchText);
				result = "Matched";
			}
		}
		return result;
		
	}
	
	//Method to search for any text. input: string and output: void
	public void search(String Text)
	{
		WebElement input = driver.findElement(search_textbox);
		input.clear();
        input.sendKeys(Text);
        input.sendKeys(Keys.RETURN);
		
	}
	
	

}
