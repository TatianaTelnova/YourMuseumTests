package main;

import org.openqa.selenium.*;

public abstract class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By by) {
        driver.findElement(by).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected int countElement(By by) {
        return driver.findElements(by).size();
    }

    protected java.util.List<WebElement> getElementsList(By by){
        return driver.findElements(by);
    }
}