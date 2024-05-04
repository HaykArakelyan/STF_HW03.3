package pages;

import locators.ContactUsPageConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {
    private By emailField = By.id(ContactUsPageConstants.EMAIL_FIELD_ID);
    private By nameField = By.id(ContactUsPageConstants.NAME_FIELD_ID);
    private By messageField = By.id(ContactUsPageConstants.MESSAGE_FIELD_ID);
    private By sendButton = By.className(ContactUsPageConstants.SEND_BUTTON_CLASSNAME);


    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    public void fillCredentials(String email, String name, String message){
        WebElement emailElement = driver.findElement(emailField);
        WebElement nameElement = driver.findElement(nameField);
        WebElement messageElement = driver.findElement(messageField);

        setInputText(emailElement, email);
        setInputText(nameElement, name);
        setInputText(messageElement, message);

        clickElement(driver.findElement(sendButton));
    }

    public String getAlertText(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}
