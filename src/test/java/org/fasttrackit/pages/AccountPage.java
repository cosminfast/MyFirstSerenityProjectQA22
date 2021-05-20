package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class AccountPage extends PageObject {

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMessageParagraph;

    @FindBy( id = "billing:region_id")
    private WebElementFacade selectCitiy;

    public void selectCity(){
        waitFor(selectCitiy);
        selectCitiy.selectByVisibleText("California");
        selectCitiy.selectByValue("18");
        selectFromDropdown(selectCitiy,"California");
    }


    public void verifyWelcomeMessage(String message){
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(welcomeMessageParagraph);
        welcomeMessageParagraph.shouldContainOnlyText(message);
    }

    public boolean isWelcomeTextDisplayed(String text){
        return welcomeMessageParagraph.containsOnlyText(text);
    }

    public String getWelcomeText(){
        return welcomeMessageParagraph.getText();
    }
}
