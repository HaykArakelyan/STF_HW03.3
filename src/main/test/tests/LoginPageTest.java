package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    @Test
    public void testFailLogIn(){
        LoginPage loginPage = homePage.openLoginFrom();
        loginPage.fillCredentials("aua_sft", "invalidPassword");
        String alertMessage = loginPage.getAlertText();
        Assert.assertTrue(alertMessage.contains("Wrong password"));
    }
    @Test
    public void testSuccessfulLogIn(){
        LoginPage loginPage = homePage.openLoginFrom();
        loginPage.fillCredentials("aua_sft", "VeryGoodPassword12!");
        String nameOfUser = loginPage.getNameOfUser();
        Assert.assertTrue(nameOfUser.contains("aua_sft"));
    }
}
