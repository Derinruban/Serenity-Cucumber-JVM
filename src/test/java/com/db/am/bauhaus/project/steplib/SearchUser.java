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
            case "Headbands":
                mainSearchPage.moveToElement(mainSearchPage.accessoriesHeader);
                mainSearchPage.moveToElement(mainSearchPage.accessoriesNav);
                mainSearchPage.accessoriesNav.click();
//                mainSearchPage.moveToElement(mainSearchPage.headbandsNav);
                mainSearchPage.headbandsNav.click();
                break;
            case "Handbags":
                mainSearchPage.moveToElement(mainSearchPage.accessoriesHeader);
                mainSearchPage.moveToElement(mainSearchPage.bagsNav);
                mainSearchPage.bagsNav.click();
//                mainSearchPage.moveToElement(mainSearchPage.handbagsNav);
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
}
