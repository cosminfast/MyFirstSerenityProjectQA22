package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;


    @Test
    public void SearchByValidKeyword() {
        searchSteps.navigateToHomepage();
        searchSteps.searchByKeyword("neck");
        searchSteps.verifyResultsContains("CHELSEA Tee");
    }

    @Test
    public void verifySortByPrice(){
        searchSteps.navigateToHomepage();
        searchSteps.searchByKeyword("neck");
        searchSteps.verifySortByPriceAscending();

    }

}
