package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	
	protected WebDriver driver;
	public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	protected void quit(){
		driver.quit();
	}

	public void goToPage(String URL) {
		driver.get(URL);
	}
	
	public String getPageTitle() {
	     return driver.getTitle();
	}
}
