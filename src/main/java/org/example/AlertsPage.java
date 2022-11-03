package org.example;

import implementation.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage{

    public AlertsPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(id = "promptexample")
    private WebElement promptButton;
    WebElement textPrompt = driver.findElement(By.id("promptreturn"));
    public void promptBox() {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromedriver();
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            promptButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Mesajul din alerta este: " + alert.getText());
            alert.sendKeys("Am introdus un text nou in alerta");
            alert.accept();
            WebElement getTextAlert = driver.findElement(By.id("promptexplanation"));
            System.out.println(getTextAlert.getText());

            System.out.println("Este deschisa alerta dupa ce a fost inchisa? " + isAlertOpen(driver));
        } catch (UnhandledAlertException e) {
            System.out.println("Ramura catch");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
