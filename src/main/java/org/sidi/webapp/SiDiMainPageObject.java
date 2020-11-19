package org.sidi.webapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.GenericPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SiDiMainPageObject extends GenericPageObject {

	private WebDriver driver;
	private int timeout = 15;

	@FindBy(xpath = "/html/body/section[6]/div[1]/div/div/div/a")
	private WebElement jobsButton;

	@FindBy(className = "menu-sc")
	@CacheLookup
	private WebElement menuButton;

	@FindBy(id = "menu-item-542")
	@CacheLookup
	private WebElement careersButton;

	@FindBy(id = "cookie_action_close_header")
	@CacheLookup
	private WebElement acceptCookie;

	@FindBy(id = "menu-item-540")
	@CacheLookup
	private WebElement inicioOption;

	@FindBy(id = "menu-item-615")
	@CacheLookup
	private WebElement nosOption;

	@FindBy(id = "menu-item-541")
	@CacheLookup
	private WebElement solucoesOption;

	@FindBy(id = "menu-item-141")
	@CacheLookup
	private WebElement casesOption;

	@FindBy(id = "menu-item-175")
	@CacheLookup
	private WebElement blogOption;

	@FindBy(id = "menu-item-176")
	@CacheLookup
	private WebElement noticiasOption;

	@FindBy(id = "menu-item-542")
	@CacheLookup
	private WebElement carreirasOption;

	@FindBy(id = "menu-item-543")
	@CacheLookup
	private WebElement contatoOption;

	private final String pageLoadedText = "Inovando o presente para transformar o futuro.";

	private final String pageUrl = "https://www.sidi.org.br";

	public SiDiMainPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public SiDiMainPageObject open() throws InterruptedException {
		this.driver.get(this.pageUrl);
		this.verifyPageLoaded().handleCookiePopUp();
		Thread.sleep(3000);
		return this;
	}

	public SiDiMainPageObject handleCookiePopUp() {
		this.acceptCookie.click();
		new WebDriverWait(this.driver, 10).until(ExpectedConditions.invisibilityOf(this.acceptCookie));
		return this;
	}

	/**
	 * Click on "Trabalhe no SiDi"
	 *
	 * @return the MainPageObject class instance.
	 */
	public SiDiMainPageObject clickJobsButton() {
		// force visibility
		((JavascriptExecutor) this.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			jobsButton.click();
		} catch (ElementClickInterceptedException ex) {
			jobsButton.click();
		}
		return this;
	}

	public SiDiMainPageObject clickMenuButton() {
		menuButton.click();
		return this;
	}

	public SiDiMainPageObject clickCareersButton() {
		careersButton.click();
		return this;
	}

	public SiDiMainPageObject clickSubItem(String subItem) {
		switch (subItem) {
		case "nos":
			nosOption.click();
			break;
		case "solucoes":
			solucoesOption.click();
			break;
		case "cases":
			casesOption.click();
			break;
		case "blog":
			blogOption.click();
			break;
		case "noticias":
			noticiasOption.click();
			break;
		case "carreiras":
			carreirasOption.click();
			break;
		case "contato":
			contatoOption.click();
			break;
		default:
			new NotFoundException("Item not found");
		}
		return this;
	}

	public boolean checkMovedTo(String pageUrl) {
		return this.checkMovedTo(pageUrl, false);
	}

	public boolean checkMovedTo(String pageUrl, boolean shouldOpenNewTab) {

		if (shouldOpenNewTab) {
			ArrayList<String> tabsList = new ArrayList<String>(this.driver.getWindowHandles());
			this.driver.close();
			this.driver.switchTo().window(tabsList.get(1));
		}

		boolean result;
		try {
			new WebDriverWait(this.driver, 10).until(ExpectedConditions.urlContains(pageUrl));
			result = true;
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the MainPageObject class instance.
	 */
	public SiDiMainPageObject verifyPageLoaded() {
		new WebDriverWait(this.driver, 10).until(ExpectedConditions.visibilityOf(menuButton));
		return this;
	}

}