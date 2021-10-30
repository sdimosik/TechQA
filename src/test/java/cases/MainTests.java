package cases;

import org.junit.jupiter.api.Test;
import pages.NotePage;
import pages.ProfilePage;
import sources.Bots;
import sources.Navigate;

import java.util.UUID;

public class MainTests extends BaseTest {

    @Test
    public void checkChangeStatus() {
        ProfilePage profilePage = Navigate.doLoginAndOpenProfilePage(Bots.number1);
        String text = UUID.randomUUID().toString();
        profilePage
            .changeStatus(text)
            .checkStatusChanging(text)
            .clearStatus();
    }

    @Test
    public void checkCreatedNote() {
        NotePage notePage = Navigate.doLoginAndOpenNotePage(Bots.number1);
        String text = UUID.randomUUID().toString();
        notePage
            .createNote(text)
            .checkLastNote(text);
    }
}
