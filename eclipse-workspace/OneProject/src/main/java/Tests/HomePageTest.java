package Tests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;
import Utils.DriverUtils;
import io.qameta.allure.Step;

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
		
		@Step("This is step 1")
		@Test(priority = 1, description = "check the name of the cetagory is correct")
		void testCaseCategoryNames()
		{
			HomePage SPage1 = new HomePage(driver, wait);
			SPage1.NameCategory();
			actualError =SPage1.CompareLists();
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
			expectedError ="סל הקניות";
			HomePage SPage = new HomePage(driver, wait);
			actualError =SPage.checkOpenShoppingCart();
			Assert.assertEquals(actualError, expectedError);
			SPage.takeScreenShot("shopingCartEnter");
		}
		
		@AfterClass
		public void MyTearDown() {
			driver.quit();
		}
}
