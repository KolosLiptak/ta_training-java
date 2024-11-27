package com.epam.training.kolos_liptak_lukacsik.test;


import com.epam.training.kolos_liptak_lukacsik.driver.DriverSingleton;
import com.epam.training.kolos_liptak_lukacsik.service.TestDataReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


public class CommonConditions {

    protected static WebDriver driver;
    protected static String USER_NAME = "testdata.username";
    protected static String PASSWORD = "testdata.password";

    @BeforeAll
    public static void setUp(){
        driver = DriverSingleton.getDriver();
        USER_NAME = TestDataReader.getTestData(USER_NAME);
        PASSWORD = TestDataReader.getTestData(PASSWORD);
    }

    @AfterAll
    public static void cleanUp(){
        DriverSingleton.closeDriver();
    }
}
