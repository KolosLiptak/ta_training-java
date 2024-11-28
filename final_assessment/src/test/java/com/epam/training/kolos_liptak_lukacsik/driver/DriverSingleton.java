package com.epam.training.kolos_liptak_lukacsik.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;

public class DriverSingleton {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver.get() == null){
            if (System.getProperty("browser")==null){
                System.setProperty("browser", "default");
            }
            switch (System.getProperty("browser")){
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver.set(ThreadGuard.protect(new ChromeDriver()));
                    break;
                }
                default: {
                    WebDriverManager.edgedriver().setup();
                    driver.set(ThreadGuard.protect(new EdgeDriver()));
                }
            }
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    public static void closeDriver(){
        driver.get().quit();
        driver.remove();
        driver = null;
    }
}
