package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final SelenideElement SIGN_BUTTON = $(By.xpath(".//input[contains(@data-l, 't,sign_in')]"));
    private final SelenideElement WELCOME_BANNER_BUTTON = $(byXpath(".//*[@data-l='t,go_to_login_form']"));
    private final SelenideElement EMAIL_LOCATOR = $(byXpath("st.email"));
    private final SelenideElement PASSWORD_LOCATOR = $(byXpath("st.password"));

    public LoginPage() {

    }

    @Override
    protected void check() {
        EMAIL_LOCATOR.shouldBe(Condition.visible);
        PASSWORD_LOCATOR.shouldBe(Condition.visible);
    }

    public FeedPage doLoginAndGetFeedPage(final String username, final String password) {
        if (WELCOME_BANNER_BUTTON.isDisplayed()) WELCOME_BANNER_BUTTON.click();
        EMAIL_LOCATOR.sendKeys(username);
        PASSWORD_LOCATOR.sendKeys(password);
        SIGN_BUTTON.click();
        return new FeedPage();
    }
}
