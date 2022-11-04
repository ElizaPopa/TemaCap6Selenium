package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newTab;
    @FindBy(id = "windowButton")
    private WebElement newWindow;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessage;

    public BrowserWindowsPage(WebDriver driver) { super(driver); }

    public void BrowserWindows() {
        try {
            driver.get(urlDemoQA);
            newTab.click();
            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String window : windowHandles) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println("Textul din primul link accesat: " + driver.findElement(By.id("sampleHeading")).getText());
            driver.close();
            driver.switchTo().window(parentWindow);
            newWindow.click();
            Set<String> windowHandles2 = driver.getWindowHandles();
            for (String window : windowHandles2) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println("Textul din al doilea link accesat: " + driver.findElement(By.id("sampleHeading")).getText());
            driver.close();
            driver.switchTo().window(parentWindow);
            newWindowMessage.click();
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("/Users/mr.lee/Desktop//image.png");
            FileUtils.copyFile(srcFile, destinationFile);
        } catch (Exception e) {
            System.out.println("Error branch");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}