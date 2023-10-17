package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import p_05_10_2023.SwagLabsRetry;

public class SwagLabsTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessageUsernameIsMissing();
    }

    @Test(priority = 2, retryAnalyzer = SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "some user name";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessagePasswordIsMissing();
    }

    @Test(priority = 3, retryAnalyzer = SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessageUsernameAndPasswordNoUserWithThese();
    }

    @Test(priority = 4, retryAnalyzer = SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessageLockedOutUser();
    }

    @Test(priority = 5, retryAnalyzer = SwagLabsRetry.class)
    private void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        urlPage.waitForUrlToBeInventory();
        inventoryPage.getSideBurgerMenu().click();
        inventoryPage.waitForBurgerMenuToFinishSliding();
        inventoryPage.waitLogoutButtonFromBurgerMenuToAppear();
        inventoryPage.getLogoutButtonFromBurgerMenu().click();
    }

    @Test(priority = 6, retryAnalyzer = SwagLabsRetry.class)
    private void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        int numberOfAddedProductsToCart = 2;

        String addButtonProductId1 = "#add-to-cart-sauce-labs-backpack";
        String removeButtonProductId1 = "#remove-sauce-labs-backpack";
        String addButtonProductId2 = "#add-to-cart-sauce-labs-bolt-t-shirt";
        String removeButtonProductId2 = "#remove-sauce-labs-bolt-t-shirt";

        loginPage.getUsernameInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();

        //add products to cart
        inventoryPage.scrollToThing(inventoryPage.getProductById(addButtonProductId1));
        inventoryPage.getProductById(addButtonProductId1).click();
        inventoryPage.scrollToThing(inventoryPage.getProductById(addButtonProductId2));
        inventoryPage.getProductById(addButtonProductId2).click();

        //did remove button appear?
        inventoryPage.didRemoveButtonOfItemAppear(removeButtonProductId1);
        inventoryPage.didRemoveButtonOfItemAppear(removeButtonProductId2);

        //are 2 items added to cart?
        Assert.assertEquals(inventoryPage.getNumberOfItemsInCart(),
                "2",
                "Threre are more than 2 or less than 2 items in the cart, but there should be 2");
    }
}
