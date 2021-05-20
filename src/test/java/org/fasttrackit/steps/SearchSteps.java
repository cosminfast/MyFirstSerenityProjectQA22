package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void searchByKeyword(String value) {
        homePage.setSearchField(value);
        homePage.clickSearchIcon();
    }

    @Step
    public void verifyResultsContains(String value) {
        Assert.assertTrue("The product was not found!",
                searchResultsPage.isProductInList(value));
    }

    @Step
    public void setSortByPrice(){
        searchResultsPage.setSortByDropdown("Price");
    }
    @Step
    public void setSortByName(){
        searchResultsPage.setSortByDropdown("Name");
    }
    @Step
    public void setSortByRelevance(){
        searchResultsPage.setSortByDropdown("Relevance");
    }


    @Step
    public void verifySortByPriceAscending() {
        setSortByPrice();
        Assert.assertTrue("Price is not ordered ascending!",
                searchResultsPage.isSortByPriceAscending());
    }

    @Step
    public void addProductToCart(String productName) {
        Assert.assertTrue(searchResultsPage.addProductToCart(productName));
    }

    @Step
    public void addProductToCartByName(String productName){
        searchByKeyword(productName);
        addProductToCart(productName);
    }
}
