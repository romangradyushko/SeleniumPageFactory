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
	WebElement EMAIL_BUTTON_SENT_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal llc_first']")
	WebElement EMAIL_BUTTON_MAIL_IN_SENT_FOLDER_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[2]/span")
	WebElement EMAIL_INPUT_TO_LOCATOR_SENT;
	@FindBy(how=How.XPATH, xpath = "//div[@class='thread__subject-line']")
	WebElement EMAIL_INPUT_SUBJECT_LOCATOR_SENT;
	@FindBy(how=How.XPATH, xpath = "//div[@class='html-expander']")
	WebElement EMAIL_INPUT_TEXT_LOCATOR_SENT;
	@FindBy(how=How.XPATH, xpath = "//*[@id=\"PH_logoutLink\"]")
	WebElement EXIT;

	public SentMailPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public void isDraftMailSentAndDeleteFromDraft(String to, String subject, String text) {
		 waitForElementEnabled(EMAIL_BUTTON_SENT_LOCATOR);
	     EMAIL_BUTTON_SENT_LOCATOR.click();
	     waitForElementEnabled(EMAIL_BUTTON_MAIL_IN_SENT_FOLDER_LOCATOR);
	     Assert.assertEquals(driver.getTitle(), "Отправленные - Почта Mail.ru", "Receiver is invalid");
	     EMAIL_BUTTON_MAIL_IN_SENT_FOLDER_LOCATOR.click();
	     waitForElementEnabled(EMAIL_INPUT_TO_LOCATOR_SENT);
		 Assert.assertEquals(EMAIL_INPUT_TO_LOCATOR_SENT.getText(), to, "Receiver is invalid");
		 Assert.assertEquals(EMAIL_INPUT_SUBJECT_LOCATOR_SENT.getText(), subject, "Subject is invalid");
		 waitForElementEnabled(EMAIL_INPUT_TEXT_LOCATOR_SENT);
		 Assert.assertTrue(EMAIL_INPUT_TEXT_LOCATOR_SENT.getText().contains(text), "Text is invalid");
	 }
	 
	 public void goOut() {
		 EXIT.click();
	 }
	
	
	
}
