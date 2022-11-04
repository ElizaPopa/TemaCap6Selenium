import implementation.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AlertsPage;
import pages.BrowserWindowsPage;
import pages.HTMLFormsPage;

public class Base {

    WebDriver driver;
    AlertsPage alertsPage;
    BrowserWindowsPage browserWindowsPage;
    HTMLFormsPage htmlFormsPage;

    @BeforeMethod
    public void setUp() {
        driver = BrowserManager.getChromedriver();
        alertsPage = new AlertsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
        htmlFormsPage = new HTMLFormsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
