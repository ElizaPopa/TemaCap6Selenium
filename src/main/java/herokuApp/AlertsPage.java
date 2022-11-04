package herokuApp;

import implementation.BrowserManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "promptexample")
    private WebElement promptButton;
    @FindBy(id = "promptreturn")
    private WebElement textPrompt;
    @FindBy(xpath = "//a[@id='alerttest']")
    private WebElement alertsJSLink;
    @FindBy(id = "promptexplanation")
    private WebElement textAlert;
    @FindBy(id = "fakealerttest")
    private WebElement fakeAlertLink;
    @FindBy(id = "fakealert")
    private WebElement alertBoxButton;
    @FindBy(id = "dialog-ok")
    private WebElement okButton;
    @FindBy(id = "modaldialog")
    private WebElement modalField;

    public void promptBox() {
        try {
            driver = BrowserManager.getChromedriver();
            driver.get(urlHerokuApp);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", alertsJSLink);
            alertsJSLink.click();
            js.executeScript("arguments[0].scrollIntoView();", promptButton);
            promptButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Mesajul din alerta este: " + alert.getText());
            alert.sendKeys("Am introdus un text nou in alerta");
            alert.accept();
            System.out.println(textAlert.getText());
            System.out.println("Este deschisa alerta dupa ce a fost inchisa? " + isAlertOpen(driver));
        } catch (UnhandledAlertException e) {
            System.out.println("Ramura catch");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void fakeAlert() {
        WebDriver driver = null;
        try {
            driver = BrowserManager.getChromedriver();
            driver.get(urlHerokuApp);
            fakeAlertLink.click();
            alertBoxButton.click();
            okButton.click();
            modalField.click();
            okButton.click();
            System.out.println("Este deschisa alerta dupa ce a fost inchisa? " + isAlertOpen(driver));
        } catch (Exception | Error e) {
            System.out.println("Ramura catch");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static boolean isAlertOpen(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

