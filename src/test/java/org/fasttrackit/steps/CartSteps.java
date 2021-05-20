package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.junit.Assert;

public class CartSteps {

    private CartPage cartPage;
    @Step
    public void verifyProductPricesIsCorrectInCartTotalWithTax() {
        Assert.assertTrue(cartPage.isCarTotalCalculatedCorrectly());
    }
}
