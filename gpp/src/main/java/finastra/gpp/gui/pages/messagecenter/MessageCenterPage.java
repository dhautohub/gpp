package main.java.finastra.gpp.gui.pages.messagecenter;

import main.java.finastra.gpp.gui.pages.AbstractGppPage;

public class MessageCenterPage extends AbstractGppPage implements MessageCenterPageInterface {

    public static void goToPage() throws Exception{
        MESSAGE_CENTER_BUTTON.clickOnWebObject();
        try {
            isAtPage(MESSAGE_CENTER_BUTTON);
        } catch (Exception e){
            System.out.println("Page Validation Failed. Some Page Objects Not Identified");
            throw e;
        };
    }

    public static void isAtPage() throws Exception{
        isAtPage(MESSAGE_CENTER_BUTTON);
    }

    public static void clickMessageCenterButton() throws Exception {
        MESSAGE_CENTER_BUTTON.clickOnWebObject();
    };
}
