package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.ArrayList;


/**
 * Created by DRuban on 19/10/2017.
 */
public class SearchUser extends ScenarioSteps {

    private RequestSpecification request;
    private Response response;


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

    @Step
    public void use_Etsy_API() {
        request = given().baseUri("https://www.etsy.com");
    }

    @Step
    public void make_suggestive_search_request(String input) {
        response = request.get("/suggestions_ajax.php?search_type=all&search_query="+input);
    }

    @Step
    public void verify_API_response_code(Integer code) {
        Integer resp_code = response.getStatusCode();
        Assert.assertEquals(code, resp_code);
    }

    @Step
    public void verify_suggested_results(String input) {
        JsonPath jsonres = response.jsonPath();
        ArrayList<String> query = jsonres.get("results.query");
        int length = input.length();
        int i = 0;
        for (String a: query) {
            if (i <= 10) {
                Assert.assertEquals(input, a.substring(0,length));
            }
            i++;
        }
    }

    @Step
    public void make_shop_name_request(String name) {
        response = request.get("/shop_name_search_service?page=1&q="+name);
    }

    @Step
    public void verify_valid_shop_name_results(String name) {
        JsonPath jsonres = response.jsonPath();
        Integer total = jsonres.get("total_results_count");
        ArrayList<String> results = jsonres.get("results");
        Assert.assertTrue(total > 0);
        Assert.assertEquals(3, results.size());
    }

    @Step
    public void verify_invalid_shop_name_results(String name) {
        JsonPath jsonres = response.jsonPath();
        Integer total = jsonres.get("total_results_count");
        ArrayList<String> results = jsonres.get("results");
        Assert.assertTrue(total == 0);
        Assert.assertEquals(0, results.size());
    }
}
