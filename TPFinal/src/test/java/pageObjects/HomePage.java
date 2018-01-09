package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	private By searchBar = By.name("searchTerm");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterSearchWord (String word) {
		driver.findElement(searchBar).sendKeys(word);
	}
	
	public void executeSearch () {
		driver.findElement(searchBar).sendKeys(Keys.RETURN);
	}
}
