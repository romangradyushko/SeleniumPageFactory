package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MailRuTest {
	private static final String BASE_URL = "https://mail.ru/";
	private static final String LOGIN = "testnameselenium1";
	private static final String PASSWORD = "passwordselenium";
	private static final String EMAIL_ADDRESS = "testnameselenium1@gmail.com";
	private static final String SUBJECT = "Test";
	private static final String BODY_TEXT = "zvsvsvTest";
    private WebDriver driver;
	private HomePage HomePage;
	private MailPage MailPage;
	private DraftPage DraftPage;
	private SentMailPage SentMailPage;
	
    @BeforeClass
    public void setUpBefore(){
    	String exePath = "D:\\3lvl\\EPAM QA\\selenium\\Chrome driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);		
		driver = new ChromeDriver();
    	HomePage = new HomePage(driver);
    	MailPage = new MailPage(driver);
    	DraftPage = new DraftPage(driver);
    	SentMailPage = new SentMailPage(driver);
    }
    
    @AfterClass
    public void setUpAfter(){
    	SentMailPage.quit();
    }
    
    @Test
    public void loginMailRu() {
    	HomePage.goToPage(BASE_URL);
        Assert.assertEquals(HomePage.getPageTitle()/*driver.getTitle()*/, "Mail.ru: почта, поиск в интернете, новости, игры", "Incorrected title");
    	HomePage.loginMailRu(LOGIN, PASSWORD);
    	Assert.assertEquals(HomePage.getPageTitle(), "Входящие - Почта Mail.ru", "Incorrected title");	
    }
    
    @Test
    public void saveMail() {
    	MailPage.createAndSaveNewEmail(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	Assert.assertEquals(MailPage.getPageTitle(), "Входящие - Почта Mail.ru", "Incorrected title");
    }
    
    @Test
    public void verifyMail() {
    	Assert.assertEquals(DraftPage.verifyMailInDraftTo(), EMAIL_ADDRESS, "Receiver is invalid");
    	Assert.assertEquals(DraftPage.verifyMailInDraftSubject(), SUBJECT, "Subject is invalid");
    	Assert.assertTrue(DraftPage.verifyMailInDraftText().contains(BODY_TEXT), "Text is invalid");
    	DraftPage.sendMailFromDraft();
    	Assert.assertEquals(DraftPage.getPageTitle(), "Черновики - Почта Mail.ru", "Incorrected title");
    }
    
    @Test
    public void verifySentMail() {
    	SentMailPage.isDraftMailSent();
    	Assert.assertEquals(SentMailPage.getPageTitle(), "Отправленные - Почта Mail.ru", "Receiver is invalid");
    	Assert.assertEquals(SentMailPage.verifyMailTo(), EMAIL_ADDRESS, "Receiver is invalid");
    	Assert.assertEquals(SentMailPage.verifyMailSubject(), SUBJECT, "Subject is invalid");
    	Assert.assertTrue(SentMailPage.verifyMailText().contains(BODY_TEXT), "Text is invalid");
    	SentMailPage.goOut();
    }
}
