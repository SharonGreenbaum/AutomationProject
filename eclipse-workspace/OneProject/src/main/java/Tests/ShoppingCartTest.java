package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.ProudctPage;
import Utils.DriverUtils;

public class ShoppingCartTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private String expectedError=null;
	private double priceForFreeDelevery =199.00;

	@BeforeClass
	void setUp() {
		driver = DriverUtils.createDriverObj(2);
	}
		
   @Test(priority = 2, description = "check if the delevery is free")
	void checkDeleveryPrice()
	{
		ProudctPage pPage1 = new  ProudctPage(driver, wait);
		pPage1.addToCart();
		double sum = pPage1.countSumProudects();
		String actualError = pPage1.checkDeleveyMassage();
		double costForDelevery = priceForFreeDelevery-sum;
		String costForDeleveryString = String.format("%.02f", costForDelevery);		
		if (sum>199)
		{
			expectedError ="משלוח חינם";

		}
		else
		{
			expectedError ="נותר לך "+ costForDeleveryString + " ₪ " +"נוספים לקבלת משלוח חינם!";

		}
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test(priority = 1, description = "remove product from cart")
	void RemoveProductTest() {
		ProudctPage pPage = new  ProudctPage(driver, wait);
		pPage.addToCart();
		pPage.removerProductMassage();
		String actualError= pPage.checkEmtyShoppingCart();
		String expectedError ="סל הקניות שלך ריק";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test(priority = 3, description = "move to cash page")
	void moveToCashPage() {
		ProudctPage pPage = new  ProudctPage(driver, wait);
		pPage.addToCart();
		pPage.moveToCash();
	}
	
	@AfterClass
	public void MyTearDown() {
		driver.quit();
	}
}

