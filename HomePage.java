package Pages;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Help.Helper;

public class HomePage extends Helper {

	WebDriver driver;
	List<WebElement> menu;
	List<WebElement> Categories;
	private HashMap<String, By> selectorList;
	private HashMap<String, WebElement> elementList;	
	List<String> testDataToCompareList = new LinkedList<String>();
	private String actualError = "true";


	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		selectorList = new HashMap<String, By>();
		elementList = new HashMap<String, WebElement>();
		goToPage();
		initBys();
		initElements();
	}

	private void initBys() {
		selectorList.put("Search", By.id("search-input"));
		selectorList.put("ShoppingCart", By.xpath("//a[@href='/cart\']"));
		selectorList.put("Shopping", By.linkText("סל הקניות"));
	}
	private void initElements() {
		menu = driver.findElements(By.className("header__linklist-item"));
		Categories =driver.findElements(By.className("list-collections__item-image-wrapper"));
		elementList.put("Search", driver.findElement(selectorList.get("Search")));
		elementList.put("ShoppingCart", driver.findElement(selectorList.get("ShoppingCart")));

	}
	public void goToPage() {
		visit("https://www.oneprojectshop.com");
	}
	public void enterToCategory(int menuChoice)
	{
		menu.get(menuChoice).click();

	}
	public void NameCategory()
	{
		String[] arrOfStrings = {
				"NEW IN",
				"נשים",
				"גברים",
				"ילדים",
				"תינוקות",
				"BRANDS",
				"TRENDING NOW",
				"BACK TO SCHOOL"
				};
		for (String curr : arrOfStrings) {
			testDataToCompareList.add(curr);
		}
	}
	
	public String CompareLists()
	{
		System.out.println(menu.size());
		for(int i=0; i< menu.size();i++)
		{
			if(testDataToCompareList.get(i).equals(menu.get(i).getText()))
			{
				System.out.println(testDataToCompareList.get(i) + " " + menu.get(i).getText() + " - PASSED" );

			}
			else
			{
				System.out.println(testDataToCompareList.get(i) + " " + menu.get(i).getText() + " - FAILED" );
				actualError = "false";
			}
		}
		return actualError;

	}	
	public  void printCategory()
	{
		initBys();

		System.out.println(menu.size());
		
		for(int i=0; i< menu.size();i++)
		{
		System.out.println(menu.get(i).getText());
		}
	}
	
	public void searchProduct (String Proudct)
	{
		elementList.get("Search").sendKeys(Proudct);
		elementList.get("Search").sendKeys(Keys.ENTER);


	}
	public void enterShoppingCart()
	{
		elementList.get("ShoppingCart").click();

	}
	
	public String checkOpenShoppingCart()
	{
		enterShoppingCart();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		elementList.put("Shopping", driver.findElement(selectorList.get("Shopping")));
		return elementList.get("Shopping").getText();
	}

}

