package tests;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public static final String BASE_URL = "https://www.demoblaze.com/";

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void onStartUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        navigateHomePage();
    }

    @AfterClass
    public void navigateHomePage() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void onDestroy(){
        driver.quit();
    }

    @AfterMethod
    public void takeErrorScreenshot(ITestResult res){
        if (ITestResult.FAILURE == res.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(screenshot, new File("src/screenshots/screenshot" + res.getName() + ".png"));
            }
            catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }



}
