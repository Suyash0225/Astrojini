package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Baseclass;

public class EditProfilePage extends Baseclass {
	
	WebDriver driver;
	
	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and contains(@href,'profile')]/span[contains(text(),'Edit Profile')]")
	WebElement edit;
	
	@FindBy(id = "photo")   WebElement userPic;
	@FindBy(name="name") WebElement userName;
	@FindBy(name="email") WebElement userEmail;
	@FindBy(name="phone") WebElement userPhone;
	@FindBy(name="address") WebElement userAddress;
	@FindBy(name="gender") WebElement userGender;
	@FindBy(name="dob" ) WebElement  userDob;
	@FindBy(css=".as_btn.btn_bnr[type='submit']") WebElement userUpdate;
	
	public void clickeditprofile() { 
		waitForVisibility(edit,10);
		edit.click();}
	
	public void uploadProfilePicture( String filePath) {
		waitForVisibility(edit,10);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden')", userPic);
		   
		userPic.sendKeys(filePath);
		
	}
	
	public void selectGender(String gender) {
		Select dropdown = new Select(userGender);
		dropdown.selectByVisibleText(gender);
		
	}
	
	
	
	public void Editprofile(String profilepic, String name, String email, String phone, String address , String gender, String dob) {
		uploadProfilePicture(profilepic);
        userName.clear(); userName.sendKeys(name);
		userEmail.clear(); userEmail.sendKeys(email);
		userPhone.clear(); userPhone.sendKeys(phone);
		userAddress.clear(); userAddress.sendKeys(address);
		selectGender(gender);
		userDob.clear(); userDob.sendKeys(dob);

		userUpdate.click();
	}
	

}
