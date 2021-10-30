package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilePage extends BasePage {

    private static final SelenideElement STATUS_FIELD =
        $(By.xpath(".//div[contains(@data-l, 't,profileBio')]//div[contains(@data-save-url, '/dk?cmd=SaveProfileInfo')]"));
    private static final SelenideElement STATUS_TEXT_FIELD =
        $(By.xpath(".//div[contains(@class ,'text-field_cnt')]//textarea[contains(@name, 'long_bio')]"));
    private static final SelenideElement SAVE_STATUS_BUTTON = $(By.xpath(".//button[contains(@data-l, 't,textField-save')]"));
    private static final SelenideElement STATUS_TEXT_FIELD_WITH_TEXT = $(By.xpath(".//div[contains(@tsid, 'TextFieldText')]"));

    public ProfilePage() {

    }

    @Override
    protected void check() {
        STATUS_FIELD.shouldBe(Condition.visible);
    }

    public ProfilePage changeStatus(String text) {
        STATUS_FIELD.click();
        STATUS_TEXT_FIELD.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        STATUS_TEXT_FIELD.sendKeys(text);
        SAVE_STATUS_BUTTON.click();
        return this;
    }

    public ProfilePage checkStatusChanging(String expectedText) {
        STATUS_TEXT_FIELD_WITH_TEXT.shouldBe(Condition.visible);
        assertThat(STATUS_TEXT_FIELD_WITH_TEXT.text(), notNullValue());
        assertThat(expectedText, equalTo(STATUS_TEXT_FIELD_WITH_TEXT.shouldBe().text()));
        return this;
    }
}
