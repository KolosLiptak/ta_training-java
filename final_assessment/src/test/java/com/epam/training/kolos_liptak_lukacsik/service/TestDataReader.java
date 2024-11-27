package com.epam.training.kolos_liptak_lukacsik.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("testdata"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}