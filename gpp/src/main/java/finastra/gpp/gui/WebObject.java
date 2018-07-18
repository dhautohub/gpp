package main.java.finastra.gpp.gui;

public class WebObject extends Selenium{

    private String description;
    private String selector;

    public WebObject(String description, String selector) {
        this.description = description;
        this.selector = selector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }


    public WebObject clickOnWebObject() throws Exception {
        clickOnWebObject(this);
        return this;
    }

    public WebObject clickOnWebObjectWithJSE() throws Exception {
        clickOnWebObjectWithJSE(this);
        return this;
    }

    public WebObject writeToWebObject(String value) throws Exception {
        writeToWebObject(this, value);
        return this;
    }
}