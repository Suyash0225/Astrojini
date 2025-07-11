package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class HoroscopesPages {
	
	WebDriver driver;
	
	
	public HoroscopesPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dropdown-content") WebElement dropdownContent;
	@FindBy(className = "dropdown") WebElement dropdown;
	
	
	
	public void clickOnDropdown() {
		WebElement clickableElement= WaitUtils.waitForVisibility(driver, dropdown);
		new Actions(driver).moveToElement(clickableElement).perform();
        WaitUtils.waitForVisibility(driver, dropdownContent);
	}
	
	
	
	public void clickOnHoroscopeItem(String iteam) {
		WebElement getItem= WaitUtils.waitForClick(driver, 
				By.xpath("//div[@class='dropdown-content']//a[text()='"+iteam+"']"));
		getItem.click();
		
	}

}
