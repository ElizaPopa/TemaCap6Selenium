package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.JavascriptUtils;

public class BasePage {

    final JavascriptUtils jsUtils;
    WebDriver driver;
    public String urlHerokuApp = "https://testpages.herokuapp.com/styled/index.html";
    public String urlDemoQA = "https://demoqa.com/browser-windows";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jsUtils = new JavascriptUtils(driver);
        PageFactory.initElements(driver,this);
    }
}
