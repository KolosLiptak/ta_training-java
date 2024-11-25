package com.epam.training.kolos_liptak_lukacsik.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends AbstractPage{

    private static final String PRODUCTS_URL = "https://www.saucedemo.com/inventory.html";


    /*
    The task description asked for "Swag Labs" in the dashboard
    but there is no dashboard in the current version
    so I chose the "Products" element as verification
    */
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public AbstractPage openPage() {
        driver.navigate().to(PRODUCTS_URL);
        return this;
    }

    public String getProductsTitle(){
        return productsTitle.getText();
    }
}
