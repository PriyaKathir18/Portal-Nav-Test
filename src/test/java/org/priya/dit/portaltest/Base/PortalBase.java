package org.priya.dit.portaltest.Base;

import com.beust.ah.A;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.priya.dit.portaltest.ExtentReportsManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
//import org.Priya.DevInTest.Framework.Base.BaseTest;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class PortalBase {

     /**
      * WebDriver instance.
      */
    public WebDriver driver;

    /**
     * Instance of Extent Reports
     */
    protected ExtentReports report = ExtentReportsManager.getExtentReports();

    protected ExtentTest test;


    /**

    /**
     * Properties instance.
     */
    protected Properties prop;

    /**
     * Getter method.
     *
     * @return WebDriver
     */

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Constructor with WebDriver instance argument
     */

    public PortalBase(WebDriver driver){
        this.driver=driver;
    }


    /**
     * Setter method.
     *
     * @return WebDriver
     */

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Default no arg Constructor.
     * Loading input.properties.
     */

    public PortalBase() {

        String propPath = SystemUtils.getUserDir() + "/src/test/resources/input.properties";
        prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(propPath);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Launches browser of User's choice specified in input.properties file.
     */
    public void launchBrowser() {
        String browserType = prop.getProperty("browser");
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Please choose a valid browser type");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Navigates to the user specified Url in the input.properties file.
     */
    public void navigateToUrl() {
        driver.navigate().to(prop.getProperty("ApplicationUrl"));
    }

    /**
     * Locates Web element by the corresponding locator strategy.
     *
     * @param locatorKey
     * @return WebElement
     */
    public WebElement identifyElement(final String locatorKey) {
        WebElement element = null;
        String elementValue = prop.getProperty(locatorKey);
        if (locatorKey.endsWith("xpath")) {
            element = driver.findElement(By.xpath(elementValue));
        } else if (locatorKey.endsWith("id")) {
            element = driver.findElement(By.id(elementValue));
        } else if (locatorKey.endsWith("css")) {
            element = driver.findElement(By.cssSelector(elementValue));
        } else if (locatorKey.endsWith("className")) {
            element = driver.findElement(By.className(elementValue));
        } else if (locatorKey.endsWith("tagName")) {
            element = driver.findElement(By.tagName(elementValue));
        } else if (locatorKey.endsWith("linkText")) {
            element = driver.findElement(By.linkText(elementValue));
        } else if (locatorKey.endsWith("partialLinkText")) {
            element = driver.findElement(By.partialLinkText(elementValue));
        } else if (locatorKey.endsWith("name")) {
            element = driver.findElement(By.name(elementValue));
        } else {
            System.out.println("Please enter a valid locator startegy");
        }
        return element;
    }

    /**
     * Method to simulate WebElement click.
     *
     * @param locatorKey
     */
    public void clickable(final String locatorKey) {
        WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.elementToBeClickable(identifyElement(locatorKey))).click();

    }

    /**
     * Generic WebDriverWait.
     */
    private WebDriverWait getWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    /**
     * Method to move to an element
     */

    public Actions moveToElement(final WebElement element){
        Actions action = new Actions(driver);
        action.scrollToElement(element);
        return action;
    }

    /**
     * Method to simulate WebElement sendKeys.
     *
     * @param locatorKey
     * @param valuesToEnter
     */

    public void enterValueInTextField(final String locatorKey, final String valuesToEnter) {
        WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.visibilityOf(identifyElement(locatorKey))).sendKeys(valuesToEnter);
    }

    /**
     *Log Info.
     */

    public void testLogInfo(final String userMessage ){
        test.log(LogStatus.INFO,userMessage);
    }

    /**
     * Passing pass info
     * @param passInfo
     */
    public void testPassInfo(final String passInfo ){
        test.log(LogStatus.PASS,passInfo);
        //takeScreenShot();
    }

    /**
     * Passing fail info
     * @param failInfo
     */

    public void testFailInfo(final String failInfo ){
        test.log(LogStatus.FAIL,failInfo);
        takeScreenShot();
    }

    /**
     * Ashot Screenshot
     */
    public void takeScreenShot(){
        Date date= new Date();
        String fileName =date.toString().replace(" ","_").replace(":","_") + ".png";
        String screenshotPath = SystemUtils.getUserDir() + "/target/screenshots/" + fileName;
        Screenshot screenshot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"png",new File(screenshotPath));
            test.log(LogStatus.FAIL,"Screenshot attached" +test.addScreenCapture(screenshotPath));
            //test.log(LogStatus.PASS,"Screenshot attached" +test.addScreenCapture(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }








}
