package tests;

import main.EditorPage;
import main.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstTest extends TestBase {

    public static final By PICTURE_BLOCK = By.xpath("//*[@id='pctrs']//*[@id='foto']");
    public static final By LINKS = By.xpath("//body//*[@href]");
    public static final By EDITOR = By.xpath("//body//*[@href]//div[@class='Page_editor']");
    public static final By BUTTON_AXES = By.xpath("//*[@id='axes-green']");
    public static final By BUTTON_LAST = By.xpath("//*[@id='blue'][last()]");
    public static final By BUTTON_GREEN = By.xpath("//*[@id='green']");
    public static final By BUTTON_PINK = By.xpath("//*[@id='pink']");
    public static final By CANVAS = By.xpath("//canvas[@id='canvas3D']");
    public static final By EXIT = By.xpath("//*[@id='blueexit']");

    @Test
    public void testCount() throws Exception {
        new MainPage(driver).count(PICTURE_BLOCK); // проверяет количество элементов
    }

    @Test
    public void testLinks() throws Exception { // проверяет ссылки и наличие на страницах элемента canvas
        MainPage mainPage = new MainPage(driver);
        List<WebElement> links = mainPage.getLinks(LINKS);
        for (int i = 0; i < links.size(); i++){
            mainPage.getLinks(LINKS).get(i).click();
            mainPage.check(CANVAS);
            mainPage.clickBtn(EXIT);
        }
    }

    @Test
    public void testClick() throws Exception { // проверяет, что появляются кнопки "добавить" и "очистить холст"
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtn(EDITOR);
        EditorPage editorPage = new EditorPage(driver);
        editorPage.click(BUTTON_LAST);
        editorPage.click(BUTTON_GREEN);
        editorPage.click(BUTTON_PINK);
    }

    @Test
    public void testClickAxes() throws Exception { // проверяет, что появляются кнопки "добавить" и "очистить холст" после выключения координатных осей
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtn(EDITOR);
        EditorPage editorPage = new EditorPage(driver);
        editorPage.click(BUTTON_AXES);
        editorPage.click(BUTTON_LAST);
        editorPage.click(BUTTON_GREEN);
        editorPage.click(BUTTON_PINK);
    }
}