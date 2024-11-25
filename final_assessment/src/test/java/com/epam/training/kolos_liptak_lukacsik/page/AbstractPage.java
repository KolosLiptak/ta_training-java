package com.epam.training.kolos_liptak_lukacsik.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_SECONDS = 5;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}
