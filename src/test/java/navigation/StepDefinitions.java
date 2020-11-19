package navigation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.sidi.webapp.SiDiMainPageObject;

import com.automation.framework.BrowserStrategy;

public class StepDefinitions {

	public BrowserStrategy browser;
	public SiDiMainPageObject sidiMainPage;

	public WebDriver webdriver;

	@Before
	public void setup() throws Exception {
		browser = new BrowserStrategy(System.getProperty("browser"));
		webdriver = browser.getDriver();
		sidiMainPage = new SiDiMainPageObject(webdriver);
	}

	@After
	public void tearDown() {
		webdriver.close();
	}

	@Given("I have the SiDi Website opened")
	public void i_have_the_sidi_website_opened() throws Exception {
		sidiMainPage.open();
	}

	@When("I click on {word} inside the menu")
	public void i_click_on_subitem_inside_the_menu(String subItem) {
		sidiMainPage
			.clickMenuButton()
			.clickSubItem(subItem);
	}

	@When("I click on jobs button")
	public void i_click_on_jobs_button() {
		sidiMainPage.clickJobsButton();
	}

	@Then("I should reach {word} Page")
	public void then_i_should_reach_subitem_page(String subItem) {
		assertTrue(sidiMainPage.checkMovedTo(subItem));
	}

	@Then("I should be reach SiDi Jobs Page")
	public void i_should_be_reach_si_di_jobs_page() {
		assertTrue(sidiMainPage.checkMovedTo("sidi.gupy.io", true));

	}

}