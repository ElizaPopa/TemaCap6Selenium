import pages.HTMLFormsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HTMLTests extends Base {

    @Test
    public void formTests() {
        htmlFormsPage.HTMLFormsExample();
    }

    @Test
    public void windowsLinkTests() {
        htmlFormsPage.windowsLinks();
    }
}
