package steps;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import utils.Context;

public class SearchBook {
	
	private HomePage home;
	private Context context;
	private WebDriver driver;
	
	public SearchBook (Context context) {
		this.context = context;
		driver = context.getDriver();
		home =  new HomePage(driver);
		
	}
	
	@Given("I enter a (.*)")
	public void i_enter_a (String book) {
		home.enterSearchWord(book);
	}
	
	@When("I press Search button")
	public void i_press_search_button() {
		home.executeSearch();
	}
	
	@Then("Result page must be shown")
	public void result_page_must_be_shown() {
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains("Search results for Sailor moon vol 7"));
	}
}
