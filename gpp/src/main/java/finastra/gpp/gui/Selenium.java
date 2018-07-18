package main.java.finastra.gpp.gui;

import main.java.finastra.gpp.gui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Selenium {

    private static WebDriver driver = Driver.getWebDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 20);

    public static void clickOnWebObject(WebObject webObject) throws Exception {
        System.out.println("Clicking on the WeBObject " + webObject.getDescription());
        WebElement element = findWebElement(webObject.getSelector());
        element.click();
    }

    public static void clickOnWebObjectWithJSE(WebObject webObject) throws Exception {
        System.out.println("Clicking on the WeBObject " + webObject.getDescription());
        WebElement element = findWebElement(webObject.getSelector());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public static void writeToWebObject(WebObject webObject, String value) throws Exception {
        System.out.println("Writing: " + value + " to the WebObject: " + webObject.getDescription());
        WebElement element = findWebElement(webObject.getSelector());
        element.clear();
        element.sendKeys(value);
    }

    public static WebElement findWebElement(String selector) throws Exception {
        WebElement element = null;
        int maxNumOfTries = 3;
        for(int i = 1; i <= maxNumOfTries; i++){
            try {
                if(selector.contains("//")) {
                    element = driver.findElement(By.xpath(selector));
                } else {
                    element = driver.findElement(By.cssSelector(selector));
                }
                break;
            }
            catch (Exception e) {
                if (i <= maxNumOfTries) {
                    waitInMiliSeconds(2000);
                }
                else {
                    System.out.println("Failed to Identify Web Element with Selector: " + selector + "...");
                    throw e;
                }
            }
        }
        return element;
    }
    
    public static void waitInMiliSeconds(long miliSeconds){
        long time = System.currentTimeMillis();
        long stopTime = time + miliSeconds;
        while(time < stopTime){
            time = System.currentTimeMillis();
        }
    }
}
