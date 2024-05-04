package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.MonitorsPage;
import pages.ProductPage;

public class AllPOMTests extends BaseTest{
    @Test
    public void runAllTest(){
        LoginPage loginPage = homePage.openLoginFrom();
        loginPage.fillCredentials("aua_sft", "invalidPassword");
        String message = loginPage.getAlertText();
        Assert.assertTrue(message.contains("Wrong password"));

        homePage.openLoginFrom();
        loginPage.fillCredentials("aua_sft", "VeryGoodPassword12!");
        String userName = loginPage.getNameOfUser();
        Assert.assertTrue(userName.contains("aua_sft"));

        int numberOfElements = homePage.getNumberOfProductFirstPage();
        Assert.assertEquals(numberOfElements, 9);

        MonitorsPage monitorsPage = homePage.clickMonitorCategory();
        String categoryName = monitorsPage.getCategoryName();
        Assert.assertTrue(categoryName.contains("Monitors"));

        homePage.clickMonitorCategory();
        String firstProductName = monitorsPage.getTheNameOfFirstProduct();
        Assert.assertTrue(firstProductName.contains("Apple monitor 24"));

        ProductPage productPage = homePage.clickMonitorCategory().openTheFirstProduct();
        String productTitle = productPage.getProductTitle();
        Assert.assertTrue(productTitle.contains("Apple monitor 24"));

        productPage.clickAddToCartButton();
        String addToCardMessage = productPage.getAlertText();
        Assert.assertTrue(addToCardMessage.contains(("Product added")));

        ContactUsPage contactUsPage = homePage.openContactUsForm();
        contactUsPage.fillCredentials("abc", "abc", "abc");
        String contactMessage = contactUsPage.getAlertText();
        Assert.assertTrue(contactMessage.contains("Thanks for the message"));
    }
}
