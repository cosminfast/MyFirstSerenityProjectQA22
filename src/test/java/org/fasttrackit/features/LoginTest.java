package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void loginWithValidCredentials() {
        loginSteps.navigateToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.clickLogIn();
        loginSteps.checkUserIsLoggedIn("Hello, Cosmin Fast!");
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginSteps.navigateToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL, "11111111");
        loginSteps.clickLogIn();
        loginSteps.checkNotLoggedIn();
    }


}
