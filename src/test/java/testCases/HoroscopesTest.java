package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.HoroscopesPages;
import utils.WaitUtils;

public class HoroscopesTest extends Baseclass{
	
	
	
	public void goToRegisterPage() {
	    driver.get(navigateTo("login_url"));
	}
	
@Test(dataProvider = "horoscopeData")
public void horoscope(String horoscopeType) {
	
	HoroscopesPages horoscopesPages = new HoroscopesPages(driver);
	goToRegisterPage();
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	horoscopesPages.clickOnDropdown();
    horoscopesPages.clickOnHoroscopeItem(horoscopeType);
    String headline = horoscopeType.replace("Horoscopes", "").trim();
    WebElement heading = WaitUtils.waitForVisibility(driver,
    	    By.xpath("//h1[contains(text(),'" +headline+ " Horoscopes')]"));
    	Assert.assertTrue(heading.isDisplayed(), "Yearly Horoscope page not loaded");

}


@DataProvider(name = "horoscopeData")
public Object[][] horoscopeData() {
	return new Object[][] {
		{"Yearly Horoscopes"},
		{"Weekly Horoscopes"},
		{"Today Horoscopes"}
	};

}
}
