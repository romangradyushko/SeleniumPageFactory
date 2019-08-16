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
	WebElement emailButtonDraftFolderLocator;
	@FindBy(how=How.XPATH, xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal llc_first']")
	WebElement emailButtonMailInDraftFolderLocator;
	@FindBy(how=How.XPATH, xpath = "//div[@class='contacts--1ofjA' and @data-type='to']")
	WebElement emailInputToLocatorDraft;
	@FindBy(how=How.XPATH, xpath = "//input[@class='container--H9L5q size_s--3_M-_' and @tabindex='400']")
	WebElement emailInputSubjectLocatorDraft;
	@FindBy(how=How.XPATH, xpath = ".//div[@role='textbox']")
	WebElement emailInputTextLocatorDraft;
	@FindBy(how=How.XPATH, xpath = "//span[@class='button2__wrapper' and @tabindex='570']")
	WebElement emailButtonSendLocator;
	@FindBy(how=How.XPATH, xpath = "//span[@class='button2__wrapper' and @tabindex='1000']")
	WebElement emailButtonExitSendLocator;
	
	
	public DraftPage(WebDriver driver) {
        super(driver);
    }
	
	public void waitForElementEnabled(WebElement lOGIN_INPUT_LOCATOR2) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(lOGIN_INPUT_LOCATOR2));
	}
	
	public String verifyMailInDraftTo() {
		waitForElementEnabled(emailButtonDraftFolderLocator);
		emailButtonDraftFolderLocator.click();
		waitForElementEnabled(emailButtonMailInDraftFolderLocator);
		emailButtonMailInDraftFolderLocator.click();
		waitForElementEnabled(emailInputToLocatorDraft);
		return emailInputToLocatorDraft.getText();	
	}
	
	public String verifyMailInDraftSubject() {
		return emailInputSubjectLocatorDraft.getAttribute("value");
	}
	
	public String verifyMailInDraftText() {
		return emailInputTextLocatorDraft.getText();
	}
	
	public void sendMailFromDraft() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForElementEnabled(emailButtonSendLocator);
		emailButtonSendLocator.click();
		waitForElementEnabled(emailButtonExitSendLocator);
		emailButtonExitSendLocator.click();
	}
	
}
