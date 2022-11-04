package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {

    public final String SCROLL_INTO_VIEW_SCRIPT = "arguments[0].scrollIntoView();";
    JavascriptExecutor jsExecutor;
    WebDriver driver;

    public JavascriptUtils(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void executeScriptWithArguments(String script, String argument) {
        jsExecutor.executeScript(script, argument);
    }

    public void executeScriptToElement(String script, WebElement element) {
        jsExecutor.executeScript(script, element);
    }
}
