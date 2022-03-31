package base;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private static WebDriver driver;
    private int timeOut = 10;

    public void initWebDriver(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void quitWebDriver(){
//        if(driver != null){
//            driver.close();
//            driver.quit();
//        }
    }

    public void openPage(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void waitSomeSeconds(int t){
        driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
    }

    public boolean clickElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean typeText(By locator, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(value);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String getText(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
    }
}
