package pages;

import locators.HomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final By loginButton = By.id(HomePageConstants.LOGIN_BUTTON_ID);
    private final By contactUsButton = By.xpath(HomePageConstants.CONTACT_BUTTON_XPATH);
    private final By monitorCategoryButton = By.partialLinkText(HomePageConstants.MONITOR_CATEGORY_PARTIAL_LINK_TEXT);
    private By productListContainerId = By.id(HomePageConstants.PRODUCT_LIST_CONTAINER_ID);
    private By productCardContainer = By.cssSelector(HomePageConstants.PRODUCT_CARD_CONTAINER_CSS_SELECTOR);

    public HomePage(WebDriver driver){
        super(driver);
    }


    public int getNumberOfProductFirstPage(){
        WebElement productContainer = wait.until(ExpectedConditions.elementToBeClickable(productListContainerId));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCardContainer));

        return productContainer.findElements(By.className("col-lg-4")).size();
    }

    public LoginPage openLoginFrom(){
        clickElement(driver.findElement(loginButton));
        return new LoginPage(driver);
    }

    public ContactUsPage openContactUsForm(){
        clickElement(driver.findElement(contactUsButton));
        return new ContactUsPage(driver);
    }

    public MonitorsPage clickMonitorCategory(){
        WebElement monitorCategory = wait.until(ExpectedConditions.elementToBeClickable(monitorCategoryButton));
        monitorCategory.click();
        wait.until(ExpectedConditions.urlToBe("https://www.demoblaze.com/#"));

        return new MonitorsPage(driver);
    }

}
