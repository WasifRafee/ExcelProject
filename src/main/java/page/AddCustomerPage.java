package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	String insertedName;
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement List

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_NUM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVE_BUTTON_ELEMENT;

	// Corresponding Method

	public void insertFullName(String fullName) {
		 insertedName = fullName + generateRandomNum(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompanyDropdown(String company) {
		selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, company);
	}

	public void insertEmail(String email) {
		String insertedEmail = generateRandomNum(9999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
	}

	public void insertPhone(String phone) {
		PHONE_NUM_ELEMENT.sendKeys(phone + generateRandomNum(9999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropDown(COUNTRY_DROPDOWN_ELEMENT, country);
	}

	public void clickSaveButton() throws InterruptedException {
		Thread.sleep(3000);
		SAVE_BUTTON_ELEMENT.click();
	}
	
	//tbody/tr[1]/td[3]/a
	//tbody/tr[2]/td[3]/a
	//tbody/tr[3]/td[3]/a
	//tbody/tr[i]/td[3]/a
	//tbody/tr[2]/td[3]/following-sibling::td[4]/a[2]
	String before_xpath="//tbody/tr[";
	String after_xpath="]/td[3]";
	String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
	public void verifyInsertedNameAndDelete() throws InterruptedException {
		
		Thread.sleep(3000);
		for (int i=1;i<=3;i++) {
			String enteredName =driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			//Assert.assertEquals(enteredName, insertedName,"Entered Name Doesn't Match");
			if(enteredName.contentEquals(insertedName)) {
				System.out.println("Entered names match");
				
				driver.findElement(By.xpath(before_xpath+i+after_xpath_delete)).click();
				driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			}
			break;
		}
	}
	
	
}
