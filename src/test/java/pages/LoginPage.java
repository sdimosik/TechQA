package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final By SIGN_BUTTON = byXpath(".//input[contains(@data-l, 't,sign_in')]");
    private static final By WELCOME_BANNER_BUTTON = byXpath(".//*[@data-l='t,go_to_login_form']");
    private static final By EMAIL_LOCATOR = byXpath(".//*[@id='field_email']");
    private static final By PASSWORD_LOCATOR = byXpath(".//*[@id='field_password']");

    public LoginPage() {

    }

    @Override
    protected void check() {

        if ($(WELCOME_BANNER_BUTTON).isDisplayed()) {
            $(WELCOME_BANNER_BUTTON).shouldBe(Condition.visible);
            return;
        }

        $(EMAIL_LOCATOR).shouldBe(Condition.visible);
        $(PASSWORD_LOCATOR).shouldBe(Condition.visible);
    }

    public FeedPage doLoginAndGetFeedPage(final String username, final String password) {
        if ($(WELCOME_BANNER_BUTTON).isDisplayed()) $(WELCOME_BANNER_BUTTON).click();
        $(EMAIL_LOCATOR).sendKeys(username);
        $(PASSWORD_LOCATOR).sendKeys(password);
        $(SIGN_BUTTON).click();
        return new FeedPage();
    }
}
