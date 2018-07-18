package test.java.finastra.gpp.gui;

import main.java.finastra.gpp.gui.driver.Driver;
import main.java.finastra.gpp.gui.pages.login.LoginPage;
import main.java.finastra.gpp.gui.pages.messagecenter.MessageCenterPage;
import org.testng.annotations.Test;

public class SanityTest {

    @Test
    public void loginToGppTest() throws Exception {
        Driver.getWebDriver();
        LoginPage.goToPage("http://splinux18:30160/gpp/#/user/signin");
        LoginPage.loginToGpp("EVGENY01", "abc123");
        MessageCenterPage.goToPage();
        MessageCenterPage.clickSignOut();
        LoginPage.isAtPage();
        Driver.quitDriver();

        //4.6.10
//        Driver.getWebDriver();
//        LoginPage.goToPage();
//        LoginPage.loginToGpp("ADMIN11", "abc123");
    }
}
