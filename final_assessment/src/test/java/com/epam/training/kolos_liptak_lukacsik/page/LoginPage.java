package com.epam.training.kolos_liptak_lukacsik.page;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.image.Kernel;
import java.security.Key;
import java.time.Duration;
import java.util.List;

public class LoginPage extends AbstractPage {

    private final String LOGIN_URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;


    private String errorMessageString;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGIN_URL);
        return this;
    }

    /*
    The following methods could be combined into one
    but due to the requirements of the task
    I split them into atomic actions
     */
    public LoginPage enterLoginInfo(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        return this;
    }

    /*
    The clear() method does not clear the text fields.
    This is a known issue and the suggested workarounds
    did not fix the problem here.
    The corresponding tests will fail.
     */
    public LoginPage clearUsernameField(){
        usernameField.clear();
        return this;
    }

    public LoginPage clearPasswordField(){
        passwordField.clear();
        return this;
    }


    public LoginPage clickLoginButton(){
        loginButton.click();
        setErrorMessage();
        return this;
    }

    /*
    Successful login separated from button click
    to differentiate between a successful login
    and receiving an error message
    */
    public ProductsPage loginSuccessful(){
        return new ProductsPage(driver);
    }

    public void setErrorMessage(){
        String errorPath = "//*[@data-test=\"error\"]";
        List<WebElement> errors = driver.findElements(By.xpath(errorPath));
        if (!errors.isEmpty()){
            errorMessageString = errors.get(0).getText();
        }

    }
    public String getErrorMessage(){
        return errorMessageString;
    }
}
