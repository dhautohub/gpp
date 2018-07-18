package main.java.finastra.gpp.gui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    public static WebDriverWait wait;

    private Driver() {};

    public static WebDriver getWebDriver(){

        if (driver == null) {
            driver = getInternetExplorerDriver();
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver getInternetExplorerDriver(){
        System.setProperty("webdriver.ie.driver", "C:/Users/evgeny.maizler/.soapuios/webdriver12/IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        options.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "dismiss");
        options.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
        options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        //options.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);

        try {
            Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1");
            Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
            Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8");
            Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
            Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 4351");
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        driver = new InternetExplorerDriver(options);
//        driver = new InternetExplorerDriver();
        return driver;
    }

    public static void navigateTo(String url) {
        System.out.println("Navigating to: " + url);
        long startTime = System.currentTimeMillis();
        driver.get(url);
        long stopTime = System.currentTimeMillis();
        System.out.println("Time lapsed: " + (stopTime - startTime));
    }

    public static void waitForPageToLoad() {
        wait  = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            try {
                killWebdriverProcess();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private static void killWebdriverProcess() throws Exception{
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
        Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
    }
}