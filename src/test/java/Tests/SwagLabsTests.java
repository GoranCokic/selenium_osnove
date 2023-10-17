package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import p_05_10_2023.SwagLabsRetry;

public class SwagLabsTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.getLoginForm().click();
        loginPage.waitForErrorMessage();
    }



}
