package Pages;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Help.Helper;
public class ProudctPage extends Helper {

		WebDriver driver;
		List<WebElement> Price;
		private HashMap<String, By> selectorList;
		private HashMap<String, WebElement> elementList;	


		public ProudctPage(WebDriver driver, WebDriverWait wait) {
			super(driver, wait);
			this.driver = driver;
			selectorList = new HashMap<String, By>();
			elementList = new HashMap<String, WebElement>();
			goToPage();
			initBys();
			initElements();
		}

		private void initBys() {
		selectorList.put("AddToCart",By.id("AddToCart"));
		selectorList.put("DeliveryMassage",(By.cssSelector("span[class='shipping-bar__text text--small']")));
		selectorList.put("RemoveProduct",(By.linkText("הסר")));
		selectorList.put("minusProduct",(By.cssSelector("a[href*='/cart/change']")));
		selectorList.put("emtyShoppingCar", By.cssSelector(".drawer__content--center  p"));
		selectorList.put("button",(By.className("button--full")));
		}
		
		private void initElements() {
			elementList.put("AddToCart", driver.findElement(selectorList.get("AddToCart")));
			Price =driver.findElements(By.className("price--highlight"));
		}
		
		public void goToPage() {
			visit("https://www.oneprojectshop.com/products/sr11smd99");
		}
		
		public void addToCart()
		{
			elementList.get("AddToCart").click();
		}
		
		public double countSumProudects()
		{
			double sum =0 ; 
			for(int i=0; i<Price.size(); i++)
			{
				String priceOnly =Price.get(i).getText().replaceAll("[^\\d.]", "");
				double D = Double.parseDouble(priceOnly);
				sum += D;
			}
			return sum;
		}
		
		public String checkDeleveyMassage()
		{
			waitForVisibility(selectorList.get("DeliveryMassage"));
			elementList.put("DeliveryMassage", driver.findElement(selectorList.get("DeliveryMassage")));
			String massage= elementList.get("DeliveryMassage").getText();
			return massage;
		}
		
		public void removerProductMassage()
		{
			waitForVisibility(selectorList.get("RemoveProduct"));
		    click(selectorList.get("RemoveProduct"));
		}
		
		@SuppressWarnings("deprecation")
		public String checkEmtyShoppingCart()
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			elementList.put("emtyShoppingCart", driver.findElement(selectorList.get("emtyShoppingCar")));
			return elementList.get("emtyShoppingCart").getText();
		}

		public void moveToCash()
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		    click(selectorList.get("button"));
		}
		
}


