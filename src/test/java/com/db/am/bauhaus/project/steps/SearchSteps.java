package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.pages.MainSearchPage;
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

    MainSearchPage mainSearchPage;


    @Given("^I am viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
    }

    @When("^I search for a (.+) from the input box using the Search Button$")
    public void i_search_for_a_product_from_the_input_box_using_the_Search_Button(String product) {
        user.search_from_input_box(product);
    }

    @When("^I search for (.+) from the drop-down menu$")
    public void i_search_for_a_product_from_the_drop_down_menu(String product) {
        user.search_from_dropdown(product);
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
        user.use_Etsy_API();
    }

    @Given("^I make a suggestive search get request$")
    public void i_make_a_suggestive_search_get_request() {
        user.make_suggestive_search_request();
    }

    @Then("^the response code is (.+)$")
    public void the_response_code_is(Integer code) throws Throwable {
        user.verify_API_response_code(code);
    }

    @Then("^the suggested results are correctly returned$")
    public void the_suggested_results_are_correctly_returned() {
        user.verify_suggested_results();
    }



}
