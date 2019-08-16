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
	WebElement loginInputLocator;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"mailbox:password\"]")
	WebElement passwordInputLocator;
	@FindBy(how=How.XPATH, xpath = "//label[@id='mailbox:submit']")
	WebElement enterButtonLocator;
	@FindBy(how=How.XPATH, xpath = "//span[@class='compose-button__wrapper']")
	WebElement emailButtonCreateLocator;
	
	public HomePage(WebDriver driver) {
        super(driver);
    }
	
	public void waitForElementEnabled(WebElement loginInputLocator2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(loginInputLocator2));
	}
	
	public void OpenPage() {
		driver.get(BASE_URL);	
	}
	
	public void loginMailRu(String login, String password) {
		driver.getTitle();
		waitForElementEnabled(loginInputLocator);
		loginInputLocator.click();
		loginInputLocator.sendKeys(login);
		passwordInputLocator.click();
		passwordInputLocator.sendKeys(password);
		enterButtonLocator.click();
		waitForElementEnabled(emailButtonCreateLocator);
	}
}
