package Tests;

import org.testng.annotations.Test;
import p_05_10_2023.SwagLabsRetry;

public class SwagLabsTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessageUsername();
    }

    @Test(priority = 2, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        String username = "some user name";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessagePassword();
    }
}
