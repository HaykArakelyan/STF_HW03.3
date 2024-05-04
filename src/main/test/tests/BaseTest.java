package tests;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    public static final String BASE_URL = "https://www.demoblaze.com/";
    private WebDriver driver;
    protected HomePage homePage;
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private WebDriver edgeDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        chromeDriver = BrowserFactory.createRemoteDriver("chrome");
        firefoxDriver = BrowserFactory.createRemoteDriver("firefox");
        edgeDriver = BrowserFactory.createRemoteDriver("edge");
    }

    @BeforeClass
    public void onStartUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        navigateToHomePage();
    }

    @BeforeMethod
    public void navigateToHomePage() {
        chromeDriver.get(BASE_URL);
        homePage = new HomePage(chromeDriver);

        firefoxDriver.get(BASE_URL);
        homePage = new HomePage(chromeDriver);

        edgeDriver.get(BASE_URL);
        homePage = new HomePage(edgeDriver);
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

    @AfterTest
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
        if (edgeDriver != null) {
            edgeDriver.quit();
        }
    }
}
