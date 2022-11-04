import herokuApp.AlertsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertsTests {
    WebDriver driver;
    AlertsPage alertsPage;

    @Test
    public void promptAlertTest() {
        alertsPage = new AlertsPage(driver);
        alertsPage.promptBox();
    }

    @Test
    public void fakeAlert() {
        alertsPage = new AlertsPage(driver);
        alertsPage.fakeAlert();
    }
}

