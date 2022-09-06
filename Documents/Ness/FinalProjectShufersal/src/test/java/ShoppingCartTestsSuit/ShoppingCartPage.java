package ShoppingCartTestsSuit;

import java.util.List;
import java.util.Set;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePOM.BasePage;
import SearchTestsSuit.SearchPage;

public class ShoppingCartPage extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	final String[] STRING_TO_SEARCH = { "במבה", "גארפילד", "גרפילד" };
	By addToCartBy = null;
	By popUpBy = null;
	By closePopUpBy = null;
	By hoverBy = null;
	By city = null;
	SearchPage sPage = null;
	By popUp=null;
	
	

	public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		initBys();
	}

	private void initBys() {
		hoverBy = By.cssSelector(".miglog-prod-inStock");
		addToCartBy = By.cssSelector(".js-add-to-cart");
		popUpBy = By.id("assortmentModalTitle");
		closePopUpBy = By.cssSelector(".btnClose");
		city = By.id("cityInput");
		popUp = By.id("assortmentModalTitle");


	}

	public void goToPage() {
		visit("https://www.shufersal.co.il/online/he/S");
	}

	public void searchItem(int i) {
		this.sPage = new SearchPage(driver, wait);
		sPage.searchTerm(STRING_TO_SEARCH[i]);
	}

	public void enterToShoppingCart() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		List<WebElement> ls1 = findElems(hoverBy);
//		mouseHover(ls1.get(0));
		List<WebElement> ls = findElems(addToCartBy);
//		ls.get(0).click();
		
//		driver.switchTo().alert().dismiss();
		
	   
//	    waitForVisibility(popUp);
//		waitUntilClickabilityElementLocated(closePopUpBy);
//		List<WebElement> ls2 = findElems(closePopUpBy);
//		System.out.println("the text is : " + ls2.get(11).getText());
//		ls2.get(12).click();
//		wait.until(ExpectedConditions.elementToBeClickable(city));
//		
//		((JavascriptExecutor)driver).executeScript("window.close()" );
//		 Alert alert = driver.switchTo().alert();
//		 alert.accept(); // or alert.dismiss();


//		findElem(city).sendKeys("תל אביב");
		
		
	}

}
