package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{
	public static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
	private static final String BASE_URL = "https://mail.ru/";		
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"mailbox:login\"]")
	WebElement LOGIN_INPUT_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"mailbox:password\"]")
	WebElement PASSWORD_INPUT_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//label[@id='mailbox:submit']")
	WebElement ENTER_BUTTON_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/span/span")
	WebElement EMAIL_BUTTON_CREATE_LOCATOR;
	
	public HomePage(WebDriver driver) {
        super(driver);
    }
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public void OpenPage() {
		driver.get(BASE_URL);	
	}
	
	public void loginMailRu(String login, String password) {
		driver.getTitle();
		waitForElementEnabled(LOGIN_INPUT_LOCATOR);
		LOGIN_INPUT_LOCATOR.click();
		LOGIN_INPUT_LOCATOR.sendKeys(login);
		PASSWORD_INPUT_LOCATOR.click();
		PASSWORD_INPUT_LOCATOR.sendKeys(password);
		ENTER_BUTTON_LOCATOR.click();
		waitForElementEnabled(EMAIL_BUTTON_CREATE_LOCATOR);
		//EMAIL_BUTTON_CREATE_LOCATOR.click();
        //driver.findElement(LOGIN_INPUT_LOCATOR).sendKeys(login);
        //driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        //driver.findElement(ENTER_BUTTON_LOCATOR).click();
	}	
}
