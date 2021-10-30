package sources;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.FeedPage;
import pages.LoginPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Navigate {

    private final static SelenideElement MICRO_MENU_BUTTON = $(By.xpath("//*[@id='hook_Block_ToolbarUserDropdown']/div/div[1]"));
    private final static SelenideElement LOGOUT_BUTTON = $(By.xpath("//*[@id='hook_Block_ToolbarUserDropdown']/div/div[2]/div/div[1]/div[1]/a"));
    private final static SelenideElement CONFIRM_LOGOUT_BUTTON = $(By.xpath("//*[@id='hook_FormButton_logoff.confirm_not_decorate']"));

    public static FeedPage doLogin(final String username, final String password) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLoginAndGetFeedPage(username, password);
    }

    public static ProfilePage doLoginAndOpenProfilePage(final String username, final String password, String ulr) {
        FeedPage feedPage = doLogin(username, password);
        open(ulr);
        return new ProfilePage();
    }

    // TODO вынести в Toolbar
    public static void logOut() {
        MICRO_MENU_BUTTON.click();
        LOGOUT_BUTTON.click();
        CONFIRM_LOGOUT_BUTTON.click();
    }
}