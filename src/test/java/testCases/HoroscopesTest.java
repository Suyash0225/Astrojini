package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;

public class HoroscopesTest extends Baseclass{
	
  @Test(dataProvider="Horoscopes")	
  public void checkHoroscopes(String horoscope) {
	  
	  driver.get("https://www.astrojini.com/customer/dashboard");
	  WebElement horoscopeLink = driver.findElement(By.className(".dropdown-content"));
	  System.out.println("Horoscope Link: " + horoscopeLink.getText());
	  
  }
  
  
  @DataProvider(name="Horoscopes")
  public Object[][] getHoroscopeData(){
	  
	  return new Object[][] {
		  {"Aries"},
		  {"Taurus"},
		  {"Gemini"},
		  {"Cancer"},
		  {"Leo"},
		  {"Virgo"},
		  {"Libra"},
		  {"Scorpio"},
		  {"Sagittarius"},
		  {"Capricorn"},
		  {"Aquarius"},
		  {"Pisces"}
	  };
	  
  }

}
