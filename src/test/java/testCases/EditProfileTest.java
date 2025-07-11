package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.EditProfilePage;
import pages.LoginPage;

public class EditProfileTest extends Baseclass {

	@BeforeMethod
	public void gotoLoginPage() {
		driver.get(navigateTo("login_url"));
		LoginPage obj = new LoginPage(driver);
		obj.login("kwikclean0225@gmail.com","Suyash@0225");
		// After login
		new WebDriverWait(driver, Duration.ofSeconds(10))
	    .until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//a[contains(@class,'nav-link') and contains(@href,'profile')]/span[text()='Edit Profile']")));


	}
	
	@Test(dataProvider="editData")
	public void setUpEditProfile(String profilepic, String name, String email, String phone, String address , String gender, String dob ) {
		//driver.get(navigateTo(""));	
		EditProfilePage editprofile = new EditProfilePage(driver);
		  editprofile.clickeditprofile();
         editprofile.Editprofile(profilepic,name, email, phone, address, gender, dob);
         
		
	}
	
	@DataProvider(name="editData")
	public Object[][] editData(){
		
		return new Object[][] {
			{"D:\\\\pic1.jpg","Suyash","suyashsrivastava49@gmail.com","8933871103","Ck 65/284 ","Female","12/05/1998"},
			{"","Kwik Klin","kwikclean0225@gmail.com","9335441516","noida sector 75","Male","07/12/1999"},
			{"","","suyashsrivastava49@gmail.com","89338711","Ck 65/284 ","Female","12/05/1998"},
			{"D:\\\\pic2.jpg","Kwik Klin","kwikclean0225@gmail.com","","noida sector 75","Male",""},
			};
		
	}
	}
	
	
	
	
	
	

