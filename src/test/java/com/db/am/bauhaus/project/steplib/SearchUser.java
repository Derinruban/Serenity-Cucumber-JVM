package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Assert;



/**
 * Created by DRuban on 19/10/2017.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;

    @Step
    public void search_from_input_box(String product) {
        mainSearchPage.searchFromInputBox(product);
    }

    @Step
    public void search_from_dropdown(String heading, String category, String product) {

        mainSearchPage.menuHeader(heading).click();
        mainSearchPage.menuCategory(category).waitUntilVisible().click();
        mainSearchPage.menuProduct(product).waitUntilVisible().click();
    }

    @Step
    public void verify_result_for_input_search(String product) {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(product));
    }

    @Step
    public void verify_result_for_dropdown_search(String product) {
        assertThat(mainSearchPage.getContentHeader(), containsString(product));
    }

    @Step
    public void submit_subscription_email_address() {
        mainSearchPage.emailInput.sendKeys("tester@yahoo.de");
        mainSearchPage.subscribeButton.click();
    }

    @Step
    public void submit_invalid_subscription_email_address(String email) {
        mainSearchPage.emailInput.sendKeys(email);
        mainSearchPage.subscribeButton.click();
    }

    @Step
    public void verify_confirmation_message(String message) {
        Assert.assertEquals(message, mainSearchPage.subscribeMessage.getText());
    }

    @Step
    public void verify_email_validation_message(String message) {
        Assert.assertEquals(message, mainSearchPage.emailInvalidMessage.getText());
    }

}
