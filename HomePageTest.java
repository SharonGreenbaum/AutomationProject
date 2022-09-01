package Tests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;
import Utils.DriverUtils;

public class HomePageTest {
	
		private WebDriver driver;
		private WebDriverWait wait;
		private String actualError = "true";
		private String expectedError = "true";
		final String[] PRODUCT_TO_SEARCH = { "שמלות", "חולצות", "ג'ינסים" };



		@BeforeClass
		void setUp() {
			driver = DriverUtils.createDriverObj(2);
		}
		
		@Test(priority = 1, description = "check the name of the cetagory is correct")
		void testCaseCategoryNames()
		{
			HomePage SPage = new HomePage(driver, wait);
			SPage.NameCategory();
			actualError =SPage.CompareLists();
			Assert.assertEquals(actualError, expectedError);
		}
		
		@Test(priority = 2, description = "search a product")
		void testSearchProduct()
		{
			HomePage SPage = new HomePage(driver, wait);
			SPage.searchProduct(PRODUCT_TO_SEARCH[0]);
			Assert.assertEquals(actualError, expectedError);
			SPage.takeScreenShot("ProductSearch");
		}
		
		@Test(priority = 3, description = "enter to shopping cart")
		void testEnterShoopingCart()
		{
			expectedError ="סל קניות";
			HomePage SPage = new HomePage(driver, wait);
			SPage.enterShoppingCart();
			actualError =SPage.checkOpenShoppingCart();
			Assert.assertEquals(actualError, expectedError);
			SPage.takeScreenShot("shopingCartEnter");
		}
		@AfterClass
		public void MyTearDown() {
			driver.quit();
		}
}
