package Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Data.RegistrationData;
import Pages.LoginPage;
import Utils.DriverUtils;
import Utils.ExcelUtils;

public class LoginTest {
	private WebDriver driver;
	private WebDriverWait wait;
	List<RegistrationData> lst;
	ExcelUtils eu = new ExcelUtils();
	final int COLUMN_ACTUAL_ERROR = 11;
	final String EXCEL_FILE_NAME = "xl_data.xlsx";

	private void helpTestError(int row, String nameOfErr, String nameTest) throws Exception {
		LoginPage LP = new LoginPage(driver, wait);
		LP.fillElement(lst.get(row));
		String actualError = LP.getErrorString(nameOfErr);
		String expectedError = lst.get(row).getExpectedResult();
		System.out.println("exe" + expectedError  );
		Assert.assertEquals(actualError, expectedError);
		LP.takeScreenShot(nameTest);
	}

	@BeforeClass
	void setUp() {
		driver = DriverUtils.createDriverObj(2);
		lst = new ArrayList<RegistrationData>();
		eu.readExcelFile(lst, EXCEL_FILE_NAME);
	}

	@Test(priority = 1, description = "test positive login- all filled correct")
	public void succeedLoginTest() throws Exception {
		LoginPage LP = new LoginPage(driver, wait);
		LP.fillElement(lst.get(0));
		LP.takeScreenShot("succeedLoginTest");
	}

	@Test(priority = 2, description = "test for illegal password message")
	public void illegalEmailTest() throws Exception {
		helpTestError(2, "errorEmail", "illegalEmailTest");
	}

	@AfterClass
	public void MyTearDown() {
	driver.quit();
}
}
