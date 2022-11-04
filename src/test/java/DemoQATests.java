import demoQA.BrowserWindowsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoQATests {
    ChromeDriver driver;
    BrowserWindowsPage browserWindowsPage;
    @Test
    public  void thirdTests() {
        browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage.BrowserWindows();
    }
}
