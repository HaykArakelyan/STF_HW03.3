package pages;

import locators.ProductPageConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ProductPage extends BasePage{

    private By productTitle = By.className(ProductPageConstants.PRODUCT_TITLE_CLASSNAME);
    private By addToCartButton = By.cssSelector(ProductPageConstants.ADD_TO_CART_BUTTON_CSS_SELECTOR);


    public ProductPage(WebDriver driver){
        super(driver);
    }


    public String getProductTitle(){
        waitForVisibilityOfElementLocated(productTitle);
        WebElement productTitleText = driver.findElement(productTitle);
        return productTitleText.getText();
    }

    public void clickAddToCartButton(){
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
    }

    public String getAlertText(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}
