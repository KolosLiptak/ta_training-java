package com.epam.training.kolos_liptak_lukacsik.test;

import com.epam.training.kolos_liptak_lukacsik.page.LoginPage;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class LoginTests extends CommonConditions{

    @Test
    public void loginWithEmptyCredentials(){
        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = new LoginPage(driver)
                .openPage()
                .enterLoginInfo(USER_NAME, PASSWORD)
                .clearUsernameField(USER_NAME)
                .clearPasswordField(PASSWORD)
                .clickLoginButton()
                .getErrorMessage();

        assertThat(actualErrorMessage, equalTo(expectedErrorMessage));

    }

    @Test
    public void loginWithUsernameNoPassword(){
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = new LoginPage(driver)
                .openPage()
                .enterLoginInfo(USER_NAME, PASSWORD)
                .clearPasswordField(PASSWORD)
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
                .clickLoginButton()
                .loginSuccessful()
                .getProductsTitle();

        assertThat(actualProductsTitle, equalTo(expectedProductsTitle));

    }
}
