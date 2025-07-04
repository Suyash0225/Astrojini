package Suyash.Astrojini.ui;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import landingPage.Baseclass;
import ui.LoginPage;

public class LoginTest extends Baseclass {
    @Test(dataProvider = "loginData")
	public void login (String username, String password) {
  
       LoginPage loginPage = new LoginPage(driver);
       
          loginPage.login(username, password);
          String message = getmessage(By.className("swal2-title"), 5);
          Assert.assertEquals(message,"Customer login successfully !!");
          System.out.println("Alert message: " + message);

       
      }
    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
            {"suyashsrivastava49@gmail.com", "Suyash@0225"}, // valid
            {"wronguser@gmail.com", "wrongpass"}, // invalid
           {"", ""} // blank
        };
    }


    

}
