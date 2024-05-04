package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MonitorsPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void testProductTitle(){
        MonitorsPage monitorsPage = homePage.clickMonitorCategory();
        ProductPage productPage = monitorsPage.openTheFirstProduct();
        String productName = productPage.getProductTitle();
        Assert.assertTrue(productName.contains("Apple monitor 24"));
    }

    @Test
    public void testAddToCart(){
        MonitorsPage monitorsPage = homePage.clickMonitorCategory();
        ProductPage productPage = monitorsPage.openTheFirstProduct();
        productPage.clickAddToCartButton();
        String message = productPage.getAlertText();
        Assert.assertTrue(message.contains("Product added"));
    }
}
