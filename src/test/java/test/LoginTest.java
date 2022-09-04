package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelRead;

public class LoginTest {
	WebDriver driver;

	ExcelRead exlRead = new ExcelRead("mockData\\TF_TestData.xlsx");
	String userName= exlRead.getCellData("LoginInfo", "UserName", 2);
	String password= exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidText = exlRead.getCellData("LoginInfo", "DashboardPageValidation", 2);
	
	
	//@Test
	public void userShouldBeAbleToLogin() {
		// Class Name //Object Creation // Inherit(needs to be in same package or
		// extend)
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidText);
		
		BrowserFactory.tearDown();
	}
}
