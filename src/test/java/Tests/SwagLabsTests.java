package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import p_05_10_2023.SwagLabsRetry;

public class SwagLabsTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessageUsernameIsMissing();
    }

    @Test(priority = 2, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        String username = "some user name";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessagePasswordIsMissing();
    }

    @Test(priority = 3, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenCredentialsAreWrong(){
        String username = "standard_user";
        String password = "invalidpassword";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessageUsernameAndPasswordNoUserWithThese();
    }

}
