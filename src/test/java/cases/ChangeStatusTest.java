package cases;

import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import sources.Bots;
import sources.Navigate;

public class ChangeStatusTest extends BaseTest {

    @Test
    public void checkChangeStatus() {

        ProfilePage profilePage = Navigate.doLoginAndOpenProfilePage(
            Bots.number1.username,
            Bots.number1.password,
            Bots.number1.url);

        String text = "com.technopolis.package";

        profilePage
            .changeStatus(text)
            .checkStatusChanging(text)
            .clearStatus();
    }
}
