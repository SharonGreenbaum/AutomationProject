package ShoppingCartTestsSuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.DriverUtils;

public class ShoppingCartTest {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	void setUp() {
		driver = DriverUtils.createDriverObj(2);

	}

	@Test(priority = 1, description = "test if is add to cart")
	void addToCartTest() {
		ShoppingCartPage SCP = new ShoppingCartPage(driver, wait);
		SCP.goToPage();
		SCP.searchItem(0);
//		SCP.enterToShoppingCart();

		// SCP.takeScreenShot("addToCartTest");

//		if (resultCount != null)
//			actualError = "PASS";
//		Assert.assertEquals(actualError, "PASS");
	}

//	@AfterClass
//	public void MyTearDown() {
//		driver.quit();
//	}
}
