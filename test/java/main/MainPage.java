package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage extends HelperBase{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void check(By element){
        if (!isElementPresent(element)){
            System.out.println("Элемент отсутствует на странице");
        }
    }

    public void count(By element){
        assert countElement(element) >= 7:
                "Не все элементы html успешно созданы";
    }

    public void clickBtn(By locator) {
        try {
            clickElement(locator);
        } catch (Exception e) {
            System.out.println("Элемент не найден!");
        }
    }

    public List<WebElement> getLinks(By locator){
        return getElementsList(locator);
    }
}
