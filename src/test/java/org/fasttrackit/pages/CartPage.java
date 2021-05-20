package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("http://testfasttrackit.info/selenium-test/checkout/cart/")
public class CartPage extends PageObject {

    @FindBy(css = ".product-cart-price .price")
    private List<WebElementFacade> listOfPrices;

    @FindBy(css = "strong .price")
    private WebElementFacade grandTotalPrice;

    @FindBy(css = "tbody tr:nth-child(2) .a-right .price")
    private WebElementFacade taxPrice;

    public int getProductPricesCombined() {
        int priceTotalCalculated = 0;
        for (WebElementFacade element : listOfPrices) {
            priceTotalCalculated += getPriceFromElementCart(element);
        }
        return priceTotalCalculated;
    }

    private int getPriceFromElementCart(WebElementFacade elementFacade) {
        return Integer.parseInt(elementFacade.getText().replaceAll(" RON", "").replaceAll(",", ""));
    }

    public int getGrandTotalPriceInt() {
        return getPriceFromElementCart(grandTotalPrice);
    }

    public int getTaxPriceInt() {
        return getPriceFromElementCart(taxPrice);
    }

    public boolean isCarTotalCalculatedCorrectly() {
        return (getProductPricesCombined() + getTaxPriceInt()) == getGrandTotalPriceInt();
    }

}
