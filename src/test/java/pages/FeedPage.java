package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    private static final By MSG_TOOLBAR_BUTTON = By.xpath("//*[@id='msg_toolbar_button']");

    @Override
    protected void check() {
        $(MSG_TOOLBAR_BUTTON).shouldBe(Condition.visible);
    }
}
