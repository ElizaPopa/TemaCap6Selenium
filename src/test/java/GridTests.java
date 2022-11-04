import implementation.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class GridTests extends Base {

    @Test
    public void promptAlertGridTest() throws MalformedURLException {
        RemoteWebDriver driver = BrowserManager.getRemoteWebDriver();
        alertsPage.promptBox();
        driver.quit();
    }

    @Test
    public void fakeAlertGridTest() throws MalformedURLException {
        RemoteWebDriver driver = BrowserManager.getRemoteWebDriver();
        alertsPage.fakeAlert();
        driver.quit();
    }

    @Test
    public void thirdGridTest() throws MalformedURLException {
        RemoteWebDriver driver = BrowserManager.getRemoteWebDriver();
        browserWindowsPage.BrowserWindows();
        driver.quit();
    }

    @Test
    public void formGridTests() throws MalformedURLException {
        RemoteWebDriver driver = BrowserManager.getRemoteWebDriver();
        htmlFormsPage.HTMLFormsExample();
        driver.quit();
    }

    @Test
    public void windowsLinkGridTests() throws MalformedURLException {
        RemoteWebDriver driver = BrowserManager.getRemoteWebDriver();
        htmlFormsPage.windowsLinks();
        driver.quit();
    }
}
