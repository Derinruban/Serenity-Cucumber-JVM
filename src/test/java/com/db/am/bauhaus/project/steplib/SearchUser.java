package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;


/**
 * Created by DRuban on 19/10/2017.
 */
public class SearchUser extends ScenarioSteps {

    private RequestSpecification request;
    private ValidatableResponse response;


    MainSearchPage mainSearchPage;

    @Step
    public void search_from_input_box(String product) {
        mainSearchPage.searchFromInputBox(product);
    }

    @Step
    public void search_from_dropdown(String product) {

        switch (product) {
            case "Headbands":
                mainSearchPage.moveToElement(mainSearchPage.accessoriesHeader);
                mainSearchPage.moveToElement(mainSearchPage.accessoriesNav);
                mainSearchPage.accessoriesNav.click();
                mainSearchPage.headbandsNav.click();
                break;
            case "Handbags":
                mainSearchPage.moveToElement(mainSearchPage.accessoriesHeader);
                mainSearchPage.moveToElement(mainSearchPage.bagsNav);
                mainSearchPage.bagsNav.click();
                mainSearchPage.handbagsNav.click();
                break;
        }
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
    public void use_Etsy_API() {
        request = given().baseUri("https://www.etsy.com");
    }

    @Step
    public void make_suggestive_search_request() {
        response = request.get("/suggestions_ajax.php?extras=%7B%26quot%3Bexpt%26quot%3B%3A%26quot%3Boff%26quot%3B%2C%26quot%3Blang%26quot%3B%3A%26quot%3Ben-GB%26quot%3B%2C%26quot%3Bextras%26quot%3B%3A%5B%5D%7D&version=10_12672349415_15&search_query=d&search_type=all").then();
    }

    @Step
    public void verify_API_response_code(Integer code) {
        response.statusCode(code);
    }
}
