package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.steplib.SearchApi;
import com.db.am.bauhaus.project.steplib.SearchUser;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


/**
 * Created by DRuban on 19/10/2017.
 */


public class SearchSteps {

    @Before
    public void before() {
    }

    @Steps
    SearchUser user;

    @Steps
    SearchApi api;

    MainSearchPage mainSearchPage;


    @Given("^I am viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
    }

    @When("^I search for a (.+) from the input box using the Search Button$")
    public void i_search_for_a_product_from_the_input_box_using_the_Search_Button(String product) {
        user.search_from_input_box(product);
    }

    @When("^I select a (.+) and a (.+) and a (.+) from the drop-down menu$")
    public void i_select_a_product_from_the_drop_down_menu(String heading, String category, String product) {
       user.search_from_dropdown(heading, category, product);
    }

    @When("^I select the (.+) category icon$")
    public void i_select_the_category_icon(String type)  {
        user.select_via_category_icons(type);
    }

    @Then("^the (.+) search results should be displayed$")
    public void the_search_results_should_be_displayed(String product) {
        user.verify_result_for_input_search(product);
    }

    @Then("^the (.+) content results should be displayed$")
    public void the_content_results_should_be_displayed(String product) {
        user.verify_result_for_dropdown_search(product);
    }

    @Given("^I am using the Etsy API$")
    public void i_am_using_the_Etsy_API()  {
        api.use_Etsy_API();
    }

    @Given("^I make a suggestive search get request for (.+)$")
    public void i_make_a_suggestive_search_get_request(String input) {
        api.make_suggestive_search_request(input);
    }

    @Then("^the response code is (.+)$")
    public void the_response_code_is(Integer code) throws Throwable {
        api.verify_API_response_code(code);
    }

    @Then("^the suggested results are correctly returned for (.+)$")
    public void the_suggested_results_are_correctly_returned(String input) {
        api.verify_suggested_results(input);
    }

    @When("^I make a shop name request for (.+)$")
    public void i_make_a_shop_name_request_for_names(String name) {
        api.make_shop_name_request(name);
    }

    @Then("^the shop name results are correctly returned for (.+)$")
    public void the_shop_name_results_are_correctly_returned_for_names(String name)  {
        api.verify_valid_shop_name_results(name);
    }

    @Then("^the shop name service returns no results for (.+)$")
    public void the_shop_name_service_returns_no_results_for(String name)  {
        api.verify_invalid_shop_name_results(name);
    }

    @When("^I submit a valid email addess for newsletter subscribtion$")
    public void i_submit_a_valid_email_addess_for_newsletter_subscribtion()  {
        user.submit_subscription_email_address();
    }

    @Then("^I should see a confirmation message like (.+)$")
    public void i_should_see_a_confirmation_message(String message) {
        user.verify_confirmation_message(message);
    }

    @When("^I submit an (.+) email addess for newsletter subscribtion$")
    public void i_submit_an_invalid_email_addess_for_newsletter_subscribtion(String email) {
        user.submit_invalid_subscription_email_address(email);
    }

    @Then("^I should see an email validation message like (.+)$")
    public void i_should_see_a_validation_message(String message) {
        user.verify_email_validation_message(message);
    }

}
