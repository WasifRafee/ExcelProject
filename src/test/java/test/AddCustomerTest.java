package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelRead;

public class AddCustomerTest {
	WebDriver driver;
	ExcelRead exlRead = new ExcelRead("mockData\\TF_TestData.xlsx");
	String userName= exlRead.getCellData("LoginInfo", "UserName", 2);
	String password= exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidText = exlRead.getCellData("LoginInfo", "DashboardPageValidation", 2);
	String fullName= exlRead.getCellData("AddContactInfo", "FullName", 2);
	String company= exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email= exlRead.getCellData("AddContactInfo", "Email", 2);
	String phoneNum= exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address= exlRead.getCellData("AddContactInfo", "Address", 2);
	String city= exlRead.getCellData("AddContactInfo", "City", 2);
	String country= exlRead.getCellData("AddContactInfo", "Country", 2);
	String state= exlRead.getCellData("AddContactInfo", "State", 2);
	String zip= exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.validateDashboardPage(dashboardValidText);
		Thread.sleep(3000);
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phoneNum);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.selectCountry(country);
		addCustomerPage.insertZip(zip);
		
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit']")));
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuButton();
		
		addCustomerPage.verifyInsertedNameAndDelete();
		BrowserFactory.tearDown();
	}
	
}
