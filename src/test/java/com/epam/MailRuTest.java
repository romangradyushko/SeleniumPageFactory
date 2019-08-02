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
    	driver.quit();
    }
    
    @Test
    public void loginMailRu() {
        driver.get(BASE_URL);
        Assert.assertEquals(driver.getTitle(), "Mail.ru: почта, поиск в интернете, новости, игры", "Incorrected title");
    	HomePage.loginMailRu(LOGIN, PASSWORD);
    	Assert.assertEquals(driver.getTitle(), "Входящие - Почта Mail.ru", "Incorrected title");
    }
    
    @Test
    public void saveMail() {
    	MailPage.createAndSaveNewEmail(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	Assert.assertEquals(driver.getTitle(), "Входящие - Почта Mail.ru", "Incorrected title");
    }
    
    @Test
    public void verifyMail() {
    	DraftPage.verifyMailInDraft(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	Assert.assertEquals(driver.getTitle(), "Черновики - Почта Mail.ru", "Incorrected title");
    }
    
    @Test
    public void verifySentMail() {
    	SentMailPage.isDraftMailSentAndDeleteFromDraft(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	SentMailPage.goOut();
    }
}
