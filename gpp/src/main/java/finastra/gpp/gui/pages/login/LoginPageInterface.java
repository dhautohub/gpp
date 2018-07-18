package main.java.finastra.gpp.gui.pages.login;


import main.java.finastra.gpp.gui.WebObject;
import main.java.finastra.gpp.gui.pages.AbstractGppPage;

interface LoginPageInterface {

    //4.6.9
    public static WebObject USER_ID_INPUT = new WebObject("User ID Input Field", "//input[@id='mat-input-0']");
    public static WebObject PASSWORD_INPUT = new WebObject("Password Input Field", "//input[@id='mat-input-1']");
    public static WebObject LOGIN_BUTTONT = new WebObject("Login Button", "//button[contains(@class, 'login-button')]");

    // 4.6.10
    //public static WebObject USER_ID_INPUT = new WebObject("User ID Input Field", "//input[@id='signin-username-field']");
    //public static WebObject PASSWORD_INPUT = new WebObject("Password Input Field", "//input[@id='signin-password-field']");
    //public static WebObject LOGIN_BUTTONT = new WebObject("Login Button", "//button[@id='signin-login-button']");

}
