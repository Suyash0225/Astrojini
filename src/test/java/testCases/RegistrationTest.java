package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Baseclass;
import pages.RegistrationPage;

public class RegistrationTest extends Baseclass {
	
	public void goToRegisterPage() {
	    driver.get(navigateTo("registerURL")); 
	}
   
	@Test(dataProvider="validregistrationData")

	public void registrationValidData(String name, String dob, String birthtime,
            String gender, String phone, String email, String password,
            String confirmPassword, String address, String pincode) {
		goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(driver);
		reg.registration(name, dob, birthtime, gender, phone, email, password, confirmPassword, address, pincode);
	}
	
	
	@Test(dataProvider="invalidregistrationData")

	public void registrationInvalidData(String name, String dob, String birthtime,
            String gender, String phone, String email, String password,
            String confirmPassword, String address, String pincode) {
		goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(driver);
		reg.registration(name, dob, birthtime, gender, phone, email, password, confirmPassword, address, pincode);
		if(name.isEmpty()) {Assert.assertEquals(reg.getNameError(), "The name field is required.");}
		if(dob.isEmpty()) {Assert.assertEquals(reg.getDobError(), "The dob field is required.");}
		if (birthtime.isEmpty()) {Assert.assertEquals(reg.getBirthTimeError(), "The birth time field is required.");}
		if(gender.isEmpty()) {Assert.assertEquals(reg.getGenderError(), "The gender field is required.");}
		if(phone.isEmpty()) {Assert.assertEquals(reg.getPhoneError(), "The phone field is required.");}
		if(email.isEmpty()) {Assert.assertEquals(reg.getEmailError(), "The email field is required.");}
		if(password.isEmpty()) {Assert.assertEquals(reg.getPassword(), "The password field is required.");}
		if(confirmPassword.isEmpty()) {Assert.assertEquals(reg.getConfirmPasswordError(), "The confirm password field is required.");}
		if(address.isEmpty()) {Assert.assertEquals(reg.getAddressError(), "The address field is required.");}
		if(pincode.isEmpty()) {Assert.assertEquals(reg.getPincodeError(), "The pincode field is required.");}
		
		
		
	}
	
	
	
	
	
	
	@DataProvider(name="validregistrationData")
	public static Object[][] validregistrationData() {
		return new Object[][]{
			{"Suyash", "25/05/2025","10:45AM","Male","9696856069","suyashsivastava@gmail.com","12345","12345","Varanasi","221001"},
			{"Shubham", "02/08/1998","10:45PM","Femail","9335441516","suyshsristava@gmai.com","12345","12345","Varanasi","221001"},
			{"Shubham", "02/08/1998","10:45PM","Femail","9335441516","sashsrivastava@gmail.com","12345","12345","Varanasi","221001"}
		};
	}
	
	
	@DataProvider(name="invalidregistrationData")
	public Object[][] invalidregistrationData() {
		
		return new Object[][] {
			{"", "02/08/1998","10:45PM","Femail","9335441516","su@gmail.com","12345","12345","Varanasi","221001"},
			{"Shubham", "02/08/1998","10:45PM","","9335441516","suyas@gmail.com","12345","12345","Varanasi","221001"},
			{"Shubham", "02/08/1998","10:45PM","Femail","9335441516","s","12345","12345","Varanasi","221001"},
			{"Shubham", "02/08/1998","","Femail","9335441516","suyash@gmail.com","12345","12345","Varanasi","221001"}
			};
	}
	
	
	
	

}
