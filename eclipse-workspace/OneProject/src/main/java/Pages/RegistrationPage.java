package Pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.RegistrationData;
import Help.Helper;

public class RegistrationPage extends Helper {

	private WebDriver driver;
	private HashMap<String, By> selectorList;
	private HashMap<String, WebElement> elementList;
	private static String url = "https://www.oneprojectshop.com/account/register";
	By saveButton = By.cssSelector(".loader-button__text");

	public RegistrationPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		selectorList = new HashMap<String, By>();
		elementList = new HashMap<String, WebElement>();
		openPage();
		initBy();
		initElements();
	}

	private void initBy() {
		selectorList.put("firstName", By.id("customer[first_name]"));
		selectorList.put("lastName", By.id("customer[last_name]"));
		selectorList.put("email", By.id("customer[email]"));
		selectorList.put("password", By.id("customer[password]"));
		selectorList.put("errorPass",By.className("errors"));
	}


	private void initElements() {
		elementList.put("firstName", driver.findElement(selectorList.get("firstName")));
		elementList.put("lastName", driver.findElement(selectorList.get("lastName")));
		elementList.put("email", driver.findElement(selectorList.get("email")));
		elementList.put("password", driver.findElement(selectorList.get("password")));
	}

	private void openPage() {
		visit(url);
	}

	public void fillElement(RegistrationData rd) throws Exception {
		elementList.get("firstName").sendKeys(rd.getFirstName());
		elementList.get("lastName").sendKeys(rd.getLastName());
		elementList.get("email").sendKeys(rd.getEmail());
		elementList.get("password").sendKeys(rd.getPassword());

	}

	public void saveReg() {
		click(saveButton);
	}

	public String getErrorString() {
		return driver.findElement(selectorList.get("errorPass")).getText();
	}

}