package Pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.RegistrationData;
import Help.Helper;

public class LoginPage extends Helper {

	private WebDriver driver;
	private HashMap<String, By> selectorList;
	private HashMap<String, WebElement> elementList;
	private static String url = "https://www.oneprojectshop.com/account/login";
	List<WebElement> button;
	By saveButton = By.cssSelector(".loader-button__text");

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		selectorList = new HashMap<String, By>();
		elementList = new HashMap<String, WebElement>();
		openPage();
		initBy();
		initElements();
	}

	private void initBy() {
		selectorList.put("email", By.id("customer[email]"));
		selectorList.put("password", By.id("customer[password]"));
		button = driver.findElements(saveButton);
	}

	private void initElements() {
		elementList.put("email", driver.findElement(selectorList.get("email")));
		elementList.put("password", driver.findElement(selectorList.get("password")));
		selectorList.put("errorEmail", By.cssSelector(".banner__content"));
	}
	
	private void openPage() {
		visit(url);
	}

	public void fillElement(RegistrationData rd) throws Exception {
		elementList.get("email").sendKeys(rd.getEmail());
		elementList.get("password").sendKeys(rd.getPassword());
	}

	public void saveLogin() {
		button.get(1).click();
	}

	public String getErrorString(String str) {
		return driver.findElement(selectorList.get(str)).getText();
	}

}
