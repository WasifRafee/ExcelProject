package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver a) {
		this.driver = a;
		}
	

	@FindBy(how= How.XPATH, using = "//input[@id='username']" ) WebElement USERNAME_ELEMENT;
	
	@FindBy(how=How.XPATH,using="//input[@id='password']") WebElement PASSWORD_ELEMENT;
	
	@FindBy(how=How.XPATH, using="//button[text()='Sign in']") WebElement SIGNIN_ELEMENT;
	
	
			
	//Corresponding methods
	
	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickSignIn() {
		SIGNIN_ELEMENT.click();
	}
	
	public void performLogin(String userName,String password) {
		USERNAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_ELEMENT.click();
		
	}
}
