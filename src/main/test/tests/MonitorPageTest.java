package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MonitorsPage;

public class MonitorPageTest extends BaseTest {
    @Test
    public void testMonitorFirstPage(){
        int numberOfElements = homePage.getNumberOfProductFirstPage();
        Assert.assertEquals(numberOfElements, 2);
    }

    @Test
    public void testFirstProductName(){
        MonitorsPage monitorsPage = homePage.clickMonitorCategory();
        String firstProductName = monitorsPage.getTheNameOfFirstProduct();
        Assert.assertTrue(firstProductName.contains("Apple monitor 24"));
    }

    @Test
    public void testCategoryName(){
        MonitorsPage monitorsPage = homePage.clickMonitorCategory();
        String categoryName = monitorsPage.getCategoryName();
        Assert.assertTrue(categoryName.contains("Monitors"));
    }
}
