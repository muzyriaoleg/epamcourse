package com.bookdepository.pages;

import com.bookdepository.core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    void open(){}

    boolean isOpened(){
        return false;
    }

     WebElement find(By by) {
        return new WebDriverWait(BrowserFactory.driver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
