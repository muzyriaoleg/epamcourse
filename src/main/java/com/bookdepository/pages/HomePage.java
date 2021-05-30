package com.bookdepository.pages;

import com.bookdepository.core.BrowserFactory;
import com.bookdepository.core.Constants;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage implements Page{

    @FindBy(css = "img[alt='Bookdepository.com']")
    private WebElement logo;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/account/login/to/account']")
    private WebElement signOrRegisterButton;

    @FindBy(xpath = "//div[@class='user-nav']//i[@class='icon-user']")
    private WebElement userIcon;

    @FindBy(xpath = "//div[@class='secondary-header-wrap ']//a[text()='Shop by category']")
    private WebElement navigationMenu;

    @FindBy(css = ".promo")
    private WebElement banner;

    @FindBy(css = "input[name='searchTerm']")
    private WebElement searchInput;


    public void open() {
        BrowserFactory.get(Constants.URL);
        PageFactory.initElements(BrowserFactory.driver(), this);
        Assert.assertTrue(isOpened(), "Home page is not opened");
    }

    public boolean isOpened() {
        try {
            new WebDriverWait(BrowserFactory.driver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(logo));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void search(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
        searchInput.sendKeys(ENTER);
    }


}