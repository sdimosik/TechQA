package sources;

import pages.FeedPage;
import pages.LoginPage;
import pages.NotePage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class Navigate {

    public static FeedPage doLogin(Bot bot) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLoginAndGetFeedPage(bot.username, bot.password);
    }

    public static ProfilePage doLoginAndOpenProfilePage(Bot bot) {
        doLogin(bot);
        open(bot.profileUrl);
        return new ProfilePage();
    }

    public static NotePage doLoginAndOpenNotePage(Bot bot) {
        doLogin(bot);
        open(bot.notesUrl);
        return new NotePage();
    }
}
