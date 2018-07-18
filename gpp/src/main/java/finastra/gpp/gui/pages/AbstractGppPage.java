package main.java.finastra.gpp.gui.pages;

import main.java.finastra.gpp.gui.AbstractWebPage;
import main.java.finastra.gpp.gui.WebObject;

public abstract class AbstractGppPage extends AbstractWebPage implements AbstractGppPageInterface {

    public static void isAtPage(WebObject... pageObjects) throws Exception {
        for(WebObject pageObject : pageObjects){
            if(pageObject.findWebElement(pageObject.getSelector()) != null){
                System.out.println(pageObject.getDescription() + " Page Object Identified");
            } else {
                System.out.println("Failed to Identify " + pageObject.getDescription() + " Page Object. Trying to Proceed with Test Flow...");
                throw new Exception("Page Validation Failed. Some Page Objects Not Identified");
            }
        }
    }

    public static void clickSignOut()throws Exception{
        SIGN_OUT_BUTTON.clickOnWebObjectWithJSE();
    };
}
