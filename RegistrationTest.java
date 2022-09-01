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
import Pages.RegistrationPage;
import Utils.DriverUtils;
import Utils.ExcelUtils;

public class RegistrationTest {
	private WebDriver driver;
	private WebDriverWait wait;
	List<RegistrationData> lst;
	ExcelUtils eu = new ExcelUtils();
	final int COLUMN_ACTUAL_ERROR = 11;
	final String EXCEL_FILE_NAME = "xl_data.xlsx";


	@BeforeClass
	void setUp() {
		driver = DriverUtils.createDriverObj(2);
		lst = new ArrayList<RegistrationData>();
		eu.readExcelFile(lst, EXCEL_FILE_NAME);
	}

	@Test(priority = 2, description = "test positive registration- all filled correct")
	public void succeedRegistrationTest() throws Exception {

		RegistrationPage RP = new RegistrationPage(driver, wait);
		RP.fillElement(lst.get(0));
		RP.saveReg();
		RP.takeScreenShot("succeedRegistrationTest");
	}

	@Test(priority = 1, description = "test password too short message")
	public void passToShortTest() throws Exception {
		RegistrationPage RP = new RegistrationPage(driver, wait);
		RP.fillElement(lst.get(1));
		RP.saveReg();
		String actualError =RP.getErrorString();
		String expectedError = lst.get(1).getExpectedResult();
		Assert.assertEquals(actualError, expectedError);
		RP.takeScreenShot("passToShortTest");
	}


	@AfterClass
	public void MyTearDown() {
		driver.quit();
	}

}
