package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Baseclass;

public class LoginPage extends Baseclass {

	WebDriver driver;
	private By username = By.name("login_key");
	private By password = By.name("password");
	private By loginButton = By.xpath("//button[text()='Login']");
	private By errorMessage = By.className("swal2-title");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void entername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	private void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	private void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	public String getAlertMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	
	public void login(String user, String pass) {
		entername(user);
		enterPassword(pass);
		clickLoginButton();
		//getAlertMessage();
	}
	

	
}
