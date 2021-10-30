package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    private final SelenideElement NOTES_BUTTON_LOCATOR =
        $(By.xpath(".//a[contains(@hrefattrs, 'st.cmd=userStatuses&st._aid=NavMenu_User_StatusHistory')]"));

    @Override
    protected void check() {
        NOTES_BUTTON_LOCATOR.shouldBe(Condition.visible);
    }
}
