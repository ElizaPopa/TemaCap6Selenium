package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class HTMLFormsPage extends BasePage {

    @FindBy(xpath = "//a[@id='windowstest']")
    private WebElement htmlFormsLink;
    @FindBy(id = "HTMLFormElements")
    private WebElement form;
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "comments")
    private WebElement textArea;
    @FindBy(name = "filename")
    private WebElement chooseFileButton;
    @FindBy(name = "hiddenField")
    private WebElement hiddenInput;
    @FindBy(id = "windowstest")
    private WebElement windowsLink;
    @FindBy(linkText = "Basic Ajax in new page")
    private WebElement firstLink;
    @FindBy(id = "goattributes")
    private WebElement secondLink;
    @FindBy(css = "input[value='Code In It']")
    private WebElement codeButton;
    @FindBy(className = "explanation")
    private WebElement textMessage;
    public HTMLFormsPage(WebDriver driver) {
        super(driver);
    }

    public void HTMLFormsExample() {
        try {
            driver.get(urlHerokuApp);
            htmlFormsLink.click();
            username.sendKeys("Callie Legston");
            password.sendKeys("anatomiaLuiGrey");
            textArea.clear();
            textArea.sendKeys("This is a test text");
            chooseFileButton.sendKeys("/Users/mr.lee/Desktop/poza.png");
            System.out.println(hiddenInput.getAttribute("value"));
            List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
            checkboxes.get(1).click();
            List<WebElement> radioBoxes = driver.findElements(By.name("radioval"));
            radioBoxes.get(2).click();
            Select select = new Select(driver.findElement(By.name("multipleselect[]")));
            select.deselectAll();
            select.selectByValue("ms1");
            select.selectByValue("ms2");
            Select dropdown = new Select(driver.findElement(By.name("dropdown")));
            dropdown.selectByIndex(2);
            form.submit();
        } catch (Exception | Error e) {
            e.printStackTrace();
            if (driver != null) {
                TakesScreenshot scrShot =((TakesScreenshot)driver);
                File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File destinationFile = new File("/Users/mr.lee/Desktop/poza.png");
                try {
                    FileUtils.copyFile(srcFile, destinationFile);
                } catch (IOException ex) {
                    System.out.println("Screenshot copy failed");
                }
            } else {
                System.out.println("Driver instance failed to create successfully");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void windowsLinks() {
        try {
            driver.get(urlHerokuApp);
            htmlFormsLink.click();
            firstLink.click();
            String mainWindow = driver.getWindowHandle();
            Set<String> otherWindow = driver.getWindowHandles();
            for (String window : otherWindow) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            Select select = new Select(driver.findElement(By.name("id")));
            select.selectByValue("2");
            Select dropdown = new Select(driver.findElement(By.name("language_id")));
            dropdown.selectByIndex(2);
            codeButton.click();
            System.out.println(textMessage.getText());
            driver.switchTo().window(mainWindow);
            secondLink.click();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

