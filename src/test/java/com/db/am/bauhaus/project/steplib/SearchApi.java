package com.db.am.bauhaus.project.steplib;

import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import java.util.ArrayList;

/**
 * Created by derin.ruban on 21/10/2017.
 */
public class SearchApi {

    private RequestSpecification request;
    private Response response;

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
