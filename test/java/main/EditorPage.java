package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends HelperBase{

    public EditorPage(WebDriver driver) {
        super(driver);
    }

    public void click(By locator) {
        try {
            clickElement(locator);
        } catch (Exception e) {
            System.out.println("Элемент не найден!");
        }
    }
}

