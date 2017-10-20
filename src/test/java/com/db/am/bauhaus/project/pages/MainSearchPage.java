package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".search-button-wrapper .btn")
    WebElementFacade searchButton;

    @FindBy(id = "catnav-primary-link-10855")
    public WebElementFacade accessoriesHeader;

    @FindBy(id = "side-nav-category-link-10856")
    public WebElementFacade accessoriesNav;

    @FindBy(id = "side-nav-category-link-10865")
    public WebElementFacade bagsNav;

    @FindBy(id = "catnav-l4-10859")
    public WebElementFacade headbandsNav;

    @FindBy(id = "catnav-l3-10867")
    public WebElementFacade handbagsNav;

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public void moveToElement(WebElementFacade element) {
        withAction().moveToElement(element).perform();
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline")).getText();
    }

    public String getContentHeader() {
        return find(By.cssSelector(".content h1")).getText();
    }


}
