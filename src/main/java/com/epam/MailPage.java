package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends AbstractPage{
	public static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;		
	@FindBy(how=How.XPATH, xpath = "//span[@class='compose-button__wrapper']")
	WebElement emailButtonCreateLocator;
	@FindBy(how=How.XPATH, xpath = "//label[@class='container--zU301']")
	WebElement emailInputToLocator;
	@FindBy(how=How.XPATH, xpath = "//input[@class='container--H9L5q size_s--3_M-_' and @tabindex='400']")
	WebElement emailInputSubjectLocator;
	@FindBy(how=How.XPATH, xpath = ".//div[@role='textbox']")
	WebElement emailInputTextLocator;
	@FindBy(how=How.XPATH, xpath = "//span[@class='button2__wrapper' and @tabindex='580']")
	WebElement emailButtonSaveLocator;
	@FindBy(how=How.XPATH, xpath = "//button[@class='container--2lPGK type_base--rkphf color_base--hO-yz' and @tabindex='700']")
	WebElement emailButtonExitLocator;
	
	
	public MailPage(WebDriver driver) {
        super(driver);
    }
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public void createAndSaveNewEmail(String to, String subject, String text) {
		waitForElementEnabled(emailButtonCreateLocator);
		emailButtonCreateLocator.click();
		driver.switchTo().defaultContent();
		waitForElementEnabled(emailInputToLocator);
		emailInputToLocator.sendKeys(to);
		emailInputToLocator.click();
		emailInputSubjectLocator.sendKeys(subject);
		emailInputTextLocator.sendKeys(text);
		emailButtonSaveLocator.click();	
		emailButtonExitLocator.click();	
	}	
}
