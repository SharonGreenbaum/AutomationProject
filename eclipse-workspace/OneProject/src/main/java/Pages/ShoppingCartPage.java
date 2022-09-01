package Pages;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Help.Helper;

public class ShoppingCartPage extends Helper {
			WebDriver driver;
			private HashMap<String, By> selectorList;
			private HashMap<String, WebElement> elementList;	
			List<WebElement> proudects;

			public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
				super(driver, wait);
				this.driver = driver;
				selectorList = new HashMap<String, By>();
				elementList = new HashMap<String, WebElement>();
				initBys();
				initElements();
			}

			private void initBys() {
				selectorList.put("CountOfProduct", By.className("acsb-skip-links"));	
			}
			private void initElements() {
				elementList.put("CountOfProduct", driver.findElement(selectorList.get("CountOfProduct")));
				proudects = driver.findElements(By.className("line-item__content-wrapper"));
			}
			public void goToPage() {
				visit("https://www.oneprojectshop.com/");
			}


	}

