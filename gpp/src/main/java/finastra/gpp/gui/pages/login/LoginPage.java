package main.java.finastra.gpp.gui.pages.login;

import main.java.finastra.gpp.gui.driver.Driver;
import main.java.finastra.gpp.gui.pages.AbstractGppPage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractGppPage implements LoginPageInterface {

    private static WebDriver driver = Driver.getWebDriver();

    public static void goToPage(String envUrl) throws Exception {
        //4.6.9
        driver.get(envUrl);

        //4.6.10
        //driver.get("http://splinux18:30160/gpp/#/user/signin");
        try {
            isAtPage(USER_ID_INPUT, PASSWORD_INPUT, LOGIN_BUTTONT);
        } catch (Exception e){
            System.out.println("Page Validation Failed. Some Page Objects Not Identified");
            throw e;
        };
    }

    public static void setUserIdInput(String userName) throws Exception {
        USER_ID_INPUT.writeToWebObject(userName);
    };

    public static void setPasswordInput(String password) throws Exception {
        PASSWORD_INPUT.writeToWebObject(password);
    };

    public static void clickLoginButton() throws Exception {
        LOGIN_BUTTONT.clickOnWebObject();
    };

    public static void clickLoginButtonWithJSE() throws Exception {
        LOGIN_BUTTONT.clickOnWebObjectWithJSE();
    };



    public static void isAtPage() throws Exception{
        isAtPage(USER_ID_INPUT, PASSWORD_INPUT, LOGIN_BUTTONT);
    }

    public static void loginToGpp(String userName, String password) throws Exception {
        USER_ID_INPUT.writeToWebObject(userName);
        PASSWORD_INPUT.writeToWebObject(password);
        LOGIN_BUTTONT.clickOnWebObjectWithJSE();
    }
}
