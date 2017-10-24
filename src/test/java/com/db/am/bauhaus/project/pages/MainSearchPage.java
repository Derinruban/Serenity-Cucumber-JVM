package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by DRuban on 19/10/2017.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".search-button-wrapper .btn")
    WebElementFacade searchButton;

    @FindBy(id = "email-text")
    public WebElementFacade emailInput;

    @FindBy(css = ".subscribe-form .btn-primary")
    public WebElementFacade subscribeButton;

    @FindBy(css = ".success-signed-out.msg-success p")
    public WebElementFacade subscribeMessage;

    @FindBy(css = ".invalid-email p")
    public WebElementFacade emailInvalidMessage;

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public WebElementFacade menuHeader(String heading) {
        return $("//span[contains(.,'" + heading + "')]");
    }

    public WebElementFacade menuCategory(String category) {
        return $("//span[contains(.,'" + category + "')]");
    }

    public WebElementFacade menuProduct(String product) {
        return $("//a[contains(.,'" + product + "')]");
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline")).getText();
    }

    public String getContentHeader() {
        return find(By.cssSelector(".content h1")).getText();
    }


}
