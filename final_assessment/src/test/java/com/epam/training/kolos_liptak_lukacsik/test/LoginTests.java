package com.epam.training.kolos_liptak_lukacsik.test;

import com.epam.training.kolos_liptak_lukacsik.page.LoginPage;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class LoginTests extends CommonConditions{

    /*
    The clear() method does not clear the text fields.
    See also: comment above used method in class LoginPage.
    The tests will pass given empty credentials.
     */

    @Test
    public void loginWithEmptyCredentials(){
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = new LoginPage(driver)
                .openPage()
                .enterLoginInfo(USER_NAME, PASSWORD)
                .clearUsernameField()
                .clearPasswordField()
                .clickLoginButton()
                .getErrorMessage();

        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));

    }

    /*
    Instead of entering a password then deleting it
    I passed an empty password to workaround known issue
    and to test handling the error message.
     */
    @Test
    public void loginWithUsernameNoPassword(){
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = new LoginPage(driver)
                .openPage()
                .enterLoginInfo(USER_NAME, "")
                .clearPasswordField()
                .clickLoginButton()
                .getErrorMessage();

        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));

    }

    @Test
    public void loginWithValidCredentials(){
        String expectedProductsTitle = "Products";
        String actualProductsTitle = new LoginPage(driver)
                .openPage()
                .enterLoginInfo(USER_NAME, PASSWORD)
                .clearPasswordField()
                .clickLoginButton()
                .loginSuccessful()
                .getProductsTitle();

        assertThat(actualProductsTitle, equalTo(expectedProductsTitle));

    }
}
