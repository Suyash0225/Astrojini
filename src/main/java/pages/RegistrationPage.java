package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	// i have find all element locator
	//@FindBy(className= "sign_up") WebElement signup;
	@FindBy(name="name")WebElement username;
	@FindBy(name="dob")WebElement userdob;
	@FindBy(name="birth_time")WebElement userbirthTime;
	@FindBy(name="gender")WebElement usergender;
	@FindBy(name="phone")WebElement userphone;
	@FindBy(name="email")WebElement useremail;
	@FindBy(name="password")WebElement userpass;
	@FindBy(name="confirm_password")WebElement userconformPass;
	@FindBy(name="address")WebElement useraddress;
	@FindBy(name="pincode")WebElement userpincode;
	@FindBy(css ="button[type='submit']")WebElement submit;
	
// This is for error element locator for check confirm error message
	@FindBy(xpath = "//small[contains(text(),'The name field is required.')]") WebElement errorName;
	@FindBy(xpath = "//small[contains(text(),'The dob field is required.')]") WebElement errorDob;
	@FindBy(xpath = "//small[contains(text(),'The birth time field is required.')]") WebElement errorBirthTime;
	@FindBy(xpath = "//small[contains(text(),'The gender field is required.')]") WebElement errorGender;
	@FindBy(xpath = "//small[contains(text(),'The phone field is required.')]") WebElement errorPhone;
	@FindBy(xpath = "//small[contains(text(),'The email field is required.')]") WebElement errorEmail;
	@FindBy(xpath = "//small[contains(text(),'The password field is required.')]") WebElement errorPass;
	@FindBy(xpath = "//small[contains(text(),'The confirm password field is required.')]") WebElement errorConfirmPass;
	@FindBy(xpath = "//small[contains(text(),'The address field is required.')]") WebElement errorAddress;
	@FindBy(xpath = "//small[contains(text(),'The pincode field is required.')]") WebElement errorPincode;

	
	public void registration(String name, String dob, String birthtime,
            String gender, String phone, String email, String password,
            String confirmPassword, String address, String pincode) {
		username.sendKeys(name);
		userdob.sendKeys(dob);
		userbirthTime.sendKeys(birthtime);
		usergender.sendKeys(gender);
		userphone.sendKeys(phone);
		useremail.sendKeys(email);
		userpass.sendKeys(password);
		userconformPass.sendKeys(confirmPassword);
		useraddress.sendKeys(address);
		userpincode.sendKeys(pincode);
		submit.click();
		
		
	}
	public String getNameError() { return errorName.getText(); }
	public String getDobError() { return errorDob.getText(); }
	public String getBirthTimeError() { return errorBirthTime.getText(); }
	public String getGenderError() { return errorGender.getText(); }
	public String getPhoneError() { return errorPhone.getText(); }
	public String getEmailError() { return errorEmail.getText(); }
	public String getPassword() {return errorPass.getText();}
	public String getConfirmPasswordError() { return errorConfirmPass.getText(); }
    public String getAddressError() { return errorAddress.getText(); }
	public String getPincodeError() { return errorPincode.getText(); }
}
