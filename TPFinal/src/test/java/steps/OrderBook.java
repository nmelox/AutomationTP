package steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BookPage;
import pageObjects.HomePage;
import pageObjects.ResultPage;
import steps.SearchBook;
import utils.Context;

public class OrderBook {
	
	private ResultPage resultPage;
	private HomePage homePage;
	private BookPage bookPage;
	private Context context;
	private WebDriver driver;
	private SearchBook searchBook;
	
	public OrderBook (Context context) {
		this.context = context;
		driver = context.getDriver();
		resultPage = new ResultPage(driver);
		bookPage = new BookPage(driver);
		homePage = new HomePage(driver);
	}
	
	@Given("I sort result by (.*)")
	public void i_sort_result_by(String orderBy) {
		
		searchBook.i_enter_a("Sailor moon tomo 7");
		searchBook.i_press_search_button();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			resultPage.orderBy(orderBy);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@When("I click on first element")
	public void i_click_on_first_element() {
		resultPage.clickOnTheFirstElement();
	}
	
	@Then("Book page must be shown")
	public void book_page_on_first_element() {
		bookPage.verifyDescriptionBook();
	}
}
