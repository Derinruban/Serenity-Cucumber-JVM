package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

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
    public void search_from_dropdown(String product) {

        switch (product) {
            case "headbands":
                mainSearchPage.moveToElement(mainSearchPage.accessoriesHeader);
                mainSearchPage.moveToElement(mainSearchPage.accessoriesNav);
                mainSearchPage.moveToElement(mainSearchPage.headbandsNav);
                mainSearchPage.headbandsNav.click();
            case "dresses":
                mainSearchPage.moveToElement(mainSearchPage.clothingHeader);
        }
    }

    @Step
    public void verify_result_for_top_categories(String product) {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(product));
    }

    @Step
    public void verify_result_for_all_categories(String product) {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(product));
    }
}
