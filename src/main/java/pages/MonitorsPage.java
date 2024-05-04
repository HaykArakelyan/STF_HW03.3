    package pages;

    import locators.MonitorsPageConstant;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;

    public class MonitorsPage extends BasePage{
        private By firstProductName = By.partialLinkText(MonitorsPageConstant.PRODUCT_PARTIAL_LINK_TEXT);
        private By categoryName = By.partialLinkText(MonitorsPageConstant.CATEGORY_LINK_TEXT);

        public MonitorsPage(WebDriver driver){
            super(driver);
        }

        public String getTheNameOfFirstProduct(){
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(firstProductName));
            return firstProduct.getText();
        }

        public String getCategoryName(){
            WebElement category = wait.until(ExpectedConditions.elementToBeClickable(categoryName));
            return category.getText();
        }

        public ProductPage openTheFirstProduct(){
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(firstProductName));
            clickElement(firstProduct);
            return new ProductPage(driver);
        }

    }
