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
	WebElement EMAIL_BUTTON_CREATE_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//label[@class='container--zU301']")
	WebElement EMAIL_INPUT_TO_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//input[@class='container--H9L5q size_s--3_M-_' and @tabindex='400']")
	WebElement EMAIL_INPUT_SUBJECT_LOCATOR;
	@FindBy(how=How.XPATH, xpath = ".//div[@role='textbox']")
	WebElement EMAIL_INPUT_TEXT_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//span[@class='button2__wrapper' and @tabindex='580']")
	WebElement EMAIL_BUTTON_SAVE_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//button[@class='container--30-bI type_base--2Nryp color_base--36fu2' and @tabindex='700']")
	WebElement EMAIL_BUTTON_EXIT_LOCATOR;
	
	
	public MailPage(WebDriver driver) {
        super(driver);
    }
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public void createAndSaveNewEmail(String to, String subject, String text) {
		waitForElementEnabled(EMAIL_BUTTON_CREATE_LOCATOR);
		EMAIL_BUTTON_CREATE_LOCATOR.click();
		driver.switchTo().defaultContent();
		waitForElementEnabled(EMAIL_INPUT_TO_LOCATOR);
		EMAIL_INPUT_TO_LOCATOR.sendKeys(to);
		EMAIL_INPUT_TO_LOCATOR.click();
		EMAIL_INPUT_SUBJECT_LOCATOR.sendKeys(subject);
		EMAIL_INPUT_TEXT_LOCATOR.sendKeys(text);
		EMAIL_BUTTON_SAVE_LOCATOR.click();	
		EMAIL_BUTTON_EXIT_LOCATOR.click();	
	}
}
