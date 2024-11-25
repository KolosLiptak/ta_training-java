package com.epam.training.kolos_liptak_lukacsik.test;


import com.epam.training.kolos_liptak_lukacsik.driver.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class CommonConditions {

    protected static WebDriver driver;
    protected static final String USER_NAME = "standard_user";
    protected static final String PASSWORD = "secret_sauce";

    @BeforeAll
    public static void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterAll
    public static void cleanUp(){
        DriverSingleton.closeDriver();
    }
}
