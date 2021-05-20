package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(css = "li.item")
    private List<WebElementFacade> listOfProducts;

    @FindBy(css = ".category-products > .toolbar select[title='Sort By']")
    private WebElementFacade sortByDropdown;

    public boolean isProductInList(String productName){
        for (WebElementFacade element : listOfProducts){
            if (element.findElement(By.cssSelector(".product-name"))
                    .getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public void setSortByDropdown(String value){
        sortByDropdown.selectByVisibleText(value);
    }

    public boolean isSortByPriceAscending(){
        int firstPrice = getPriceFromProduct(listOfProducts.get(0));
        int secondPrice = getPriceFromProduct(listOfProducts.get(listOfProducts.size()-1));
        if (firstPrice <= secondPrice)
            return true;
        return false;
    }

    private int getPriceFromProduct(WebElementFacade element){
        return Integer.parseInt(element.find(By.cssSelector(".price")).getText().replaceAll(",00 RON", ""));
    }

    public boolean addProductToCart(String name){
        for (WebElementFacade elementFacade : listOfProducts){
            if (elementFacade.findElement(By.cssSelector(".product-name")).getText().equalsIgnoreCase(name)){
                elementFacade.findElement(By.cssSelector(".btn-cart")).click();
                return true;
            }
        }
        return false;
    }
}
