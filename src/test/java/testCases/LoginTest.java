package testCases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.LoginPage;

public class LoginTest extends Baseclass {
	

	@Test(dataProvider = "loginData")
	public void login (String username, String password, String expectedMessage) {
       navigateTo("login_url");
       LoginPage loginPage = new LoginPage(driver);
       
          loginPage.login(username, password);
          String actualMessage = loginPage.getAlertMessage();
          Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
          System.out.println("Alert message: " + actualMessage);

       
      }
    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
            {"kwikclean0225@gmail.com", "Suyash@0225", "Customer login successfully !!"}, // valid
            {"wronguser@gmail.com", "wrongpass", "Invalid Credentials !!"}, // invalid
        };
    }


    

}
