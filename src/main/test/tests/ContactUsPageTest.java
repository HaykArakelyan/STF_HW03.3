package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsPageTest extends BaseTest{

    @Test
    public void testSendContactUsMessage(){
        ContactUsPage contactUsPage = homePage.openContactUsForm();
        contactUsPage.fillCredentials("abc", "abc", "abc");
        String message = contactUsPage.getAlertText();
        Assert.assertTrue(message.contains("Thanks for the message"));
    }
}
