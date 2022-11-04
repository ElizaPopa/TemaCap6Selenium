import org.testng.annotations.Test;

public class AlertsTests extends Base {
    @Test
    public void promptAlertTest() {
        alertsPage.promptBox();
    }

    @Test
    public void fakeAlert() {
        alertsPage.fakeAlert();
    }
}

