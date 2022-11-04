import herokuApp.HTMLFormsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HTMLTests {
    ChromeDriver driver;
    HTMLFormsPage htmlFormsPage;

    @Test
    public void formTests() {
        htmlFormsPage = new HTMLFormsPage(driver);
        htmlFormsPage.HTMLFormsExample();
    }

    @Test
    public void windowsLinkTests() {
        htmlFormsPage = new HTMLFormsPage(driver);
        htmlFormsPage.windowsLinks();
    }
}
