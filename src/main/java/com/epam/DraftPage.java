package com.epam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DraftPage extends AbstractPage {
	public static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;	
	@FindBy(how=How.XPATH, xpath = "//a[@class='nav__item js-shortcut nav__item_shortcut' and @href='/drafts/']")
	WebElement EMAIL_BUTTON_DRAFT_FOLDER_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal llc_first']")
	WebElement EMAIL_BUTTON_MAIL_IN_DRAFT_FOLDER_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//div[@class='contacts--1ofjA' and @data-type='to']")
	WebElement EMAIL_INPUT_TO_LOCATOR_DRAFT;
	@FindBy(how=How.XPATH, xpath = "//input[@class='container--H9L5q size_s--3_M-_' and @tabindex='400']")
	WebElement EMAIL_INPUT_SUBJECT_LOCATOR_DRAFT;
	@FindBy(how=How.XPATH, xpath = ".//div[@role='textbox']")
	WebElement EMAIL_INPUT_TEXT_LOCATOR_DRAFT;
	@FindBy(how=How.XPATH, xpath = "//span[@class='button2__wrapper' and @tabindex='570']")
	WebElement EMAIL_BUTTON_SEND_LOCATOR;
	@FindBy(how=How.XPATH, xpath = "//span[@class='button2__wrapper' and @tabindex='1000']")
	WebElement EMAIL_BUTTON_EXIT_SEND_LOCATOR;
	
	
	public DraftPage(WebDriver driver) {
        super(driver);
    }
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public void verifyMailInDraft(String to, String subject, String text) {
		waitForElementEnabled(EMAIL_BUTTON_DRAFT_FOLDER_LOCATOR);
		EMAIL_BUTTON_DRAFT_FOLDER_LOCATOR.click();
		waitForElementEnabled(EMAIL_BUTTON_MAIL_IN_DRAFT_FOLDER_LOCATOR);
		EMAIL_BUTTON_MAIL_IN_DRAFT_FOLDER_LOCATOR.click();
		waitForElementEnabled(EMAIL_INPUT_TO_LOCATOR_DRAFT);
		Assert.assertEquals(EMAIL_INPUT_TO_LOCATOR_DRAFT.getText(), to, "Receiver is invalid");
		Assert.assertEquals(EMAIL_INPUT_SUBJECT_LOCATOR_DRAFT.getAttribute("value"), subject, "Subject is invalid");
		Assert.assertTrue(EMAIL_INPUT_TEXT_LOCATOR_DRAFT.getText().contains(text), "Text is invalid");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		waitForElementEnabled(EMAIL_BUTTON_SEND_LOCATOR);
		EMAIL_BUTTON_SEND_LOCATOR.click();
		waitForElementEnabled(EMAIL_BUTTON_EXIT_SEND_LOCATOR);
		EMAIL_BUTTON_EXIT_SEND_LOCATOR.click();
	}
}
