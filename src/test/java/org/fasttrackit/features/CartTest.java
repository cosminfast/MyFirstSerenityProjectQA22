package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CartSteps cartSteps;

    @Steps
    private SearchSteps searchSteps;

    @Test
    public void addToCart(){
        loginSteps.doLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);

    }
    @Test
    public void verifyProductPriceInCart(){
        searchSteps.navigateToHomepage();
        searchSteps.addProductToCartByName("3-YEAR WARRANTY");
        searchSteps.addProductToCartByName("SWING TIME EARRINGS");
        searchSteps.addProductToCartByName("SILVER DESERT NECKLACE");
        cartSteps.verifyProductPricesIsCorrectInCartTotalWithTax();
    }
}
