package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SentMailPage extends AbstractPage{
	public static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
	@FindBy(how=How.XPATH, xpath = "//a[@class='nav__item js-shortcut nav__item_shortcut' and @href='/sent/']")
	WebElement emailButtonSentLocator;
	@FindBy(how=How.XPATH, xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal llc_first']")
	WebElement emailButtonMailInSentFolderLocator;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[2]/span")
	WebElement emailInputToLocatorSent;
	@FindBy(how=How.XPATH, xpath = "//div[@class='thread__subject-line']")
	WebElement emailInputSubjectLocatorSent;
	@FindBy(how=How.XPATH, xpath = "//div[@class='html-expander']")
	WebElement emailInputTextLocatorSent;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"PH_logoutLink\"]")
	WebElement exit;

	public SentMailPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public void isDraftMailSent() {
		waitForElementEnabled(emailButtonSentLocator);
	    emailButtonSentLocator.click();
	    waitForElementEnabled(emailButtonMailInSentFolderLocator);
	}
	
	public String verifyMailTo() {
		emailButtonMailInSentFolderLocator.click();
	     waitForElementEnabled(emailInputToLocatorSent);
		return emailInputToLocatorSent.getText();
	}
	
	public String verifyMailSubject() {
		return emailInputSubjectLocatorSent.getText();
	}
	
	public String verifyMailText() {
		waitForElementEnabled(emailInputTextLocatorSent);
		return emailInputTextLocatorSent.getText();
	}
		
	public void goOut() {
		exit.click();
	}
}
