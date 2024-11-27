package com.epam.training.kolos_liptak_lukacsik.page;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends AbstractPage {

    private final String LOGIN_URL = "https://www.saucedemo.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    //xpath of the error message, used in function
    private final String errorXPath = "//*[@data-test=\"error\"]";


    private String errorMessageString;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGIN_URL);
        logger.info("Login page opened");
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
        logger.info("Login info entered");
        return this;
    }

    public LoginPage clearUsernameField(String username){
        for (int i = 0; i < username.length(); i++) {
            usernameField.sendKeys(Keys.BACK_SPACE);
        }

        return this;
    }

    public LoginPage clearPasswordField(String password){
        for (int i = 0; i < password.length(); i++) {
            passwordField.sendKeys(Keys.BACK_SPACE);
        }
        logger.info("Password field cleared");
        return this;
    }


    public LoginPage clickLoginButton(){
        loginButton.click();
        setErrorMessage();
        logger.info("Login button clicked");
        return this;
    }


    public ProductsPage loginSuccessful(){
        logger.info("Successful login");
        return new ProductsPage(driver);
    }

    public void setErrorMessage(){
        String errorPath = errorXPath;
        List<WebElement> errors = driver.findElements(By.xpath(errorPath));
        if (!errors.isEmpty()){
            errorMessageString = errors.get(0).getText();
        }

    }
    public String getErrorMessage(){
        logger.info("Error message retrieved");
        return errorMessageString;
    }
}
