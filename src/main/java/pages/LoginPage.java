package pages;

import locators.LogInPageConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class LoginPage extends BasePage {
    private final By usernameField = By.id(LogInPageConstants.USERNAME_FIELD_ID);
    private final By passwordField = By.id(LogInPageConstants.PASSWORD_FIELD_ID);
    private final By logInButton = By.xpath(LogInPageConstants.SIGN_IN_BUTTON_XPATH);
    private final By closeButton = By.xpath(LogInPageConstants.CLOSE_BUTTON_XPATH);
    private final By nameOfUser = By.id(LogInPageConstants.NAME_OF_USER_ID);
    private final By loginModal = By.id(LogInPageConstants.LOGIN_MODAL_ID);
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillCredentials(String username, String password) {
        WebElement usernameElement = driver.findElement(usernameField);
        WebElement passwordElement = driver.findElement(passwordField);

        setInputText(usernameElement, username);
        setInputText(passwordElement, password);
        clickElement(driver.findElement(logInButton));
    }

    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();

        clearInputs();

        waitForElementToBeClickable(driver.findElement(loginModal));
        WebElement closeButtonElement = driver.findElement(closeButton);
        clickElement(closeButtonElement);

        return alertText;
    }

    public String getNameOfUser() {
        waitForVisibilityOfElementLocated(nameOfUser);
        WebElement nameOfUserElement = driver.findElement(nameOfUser);
        return nameOfUserElement.getText();
    }

    public void clearInputs() {
        WebElement usernameElement = driver.findElement(usernameField);
        WebElement passwordElement = driver.findElement(passwordField);

        setInputText(usernameElement, "");
        setInputText(passwordElement, "");
    }

    public void closeLoginPage(){
        WebElement modal = driver.findElement(loginModal);
        clickElement(driver.findElement(By.className("btn-secondary")));
    }
}
