package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static sources.Utils.sendKeysWithDeleteOldValue;

public class ProfilePage extends BasePage {

    private static final By STATUS_FIELD =
        By.xpath(".//div[contains(@data-l, 't,profileBio')]//div[contains(@data-save-url, '/dk?cmd=SaveProfileInfo')]");
    private static final By STATUS_TEXT_FIELD =
        By.xpath(".//div[contains(@class ,'text-field_cnt')]//textarea[contains(@name, 'long_bio')]");
    private static final By SAVE_STATUS_BUTTON = By.xpath(".//button[contains(@data-l, 't,textField-save')]");
    private static final By STATUS_TEXT_FIELD_WITH_TEXT = By.xpath(".//div[contains(@tsid, 'TextFieldText')]");

    public ProfilePage() {

    }

    @Override
    protected void check() {
        $(STATUS_FIELD).shouldBe(Condition.visible);
    }

    public ProfilePage changeStatus(String text) {
        $(STATUS_FIELD).click();
        sendKeysWithDeleteOldValue($(STATUS_TEXT_FIELD), text);
        $(SAVE_STATUS_BUTTON).click();
        return this;
    }

    public ProfilePage checkStatusChanging(String expectedText) {
        $(STATUS_TEXT_FIELD_WITH_TEXT).shouldBe(Condition.visible);
        assertThat($(STATUS_TEXT_FIELD_WITH_TEXT).text(), notNullValue());
        assertThat(expectedText, equalTo($(STATUS_TEXT_FIELD_WITH_TEXT).shouldBe().text()));
        return this;
    }

    public ProfilePage clearStatus() {
        return changeStatus("");
    }
}
