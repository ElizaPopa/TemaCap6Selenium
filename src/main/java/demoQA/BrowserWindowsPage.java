package demoQA;

import implementation.BrowserManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    @FindBy(id = "tabButton")
    private WebElement newTab;
    @FindBy(id = "windowButton")
    private WebElement newWindow;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessage;

    public BrowserWindowsPage(ChromeDriver driver) { super(driver); }

    public void BrowserWindows() {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.getChromedriver();
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
            File file = driver.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("/Users/mr.lee/Desktop//image.png");
            FileUtils.copyFile(file, destinationFile);
        } catch (Exception | Error e) {
            System.out.println("Error branch");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
