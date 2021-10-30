package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NotePage extends BasePage {

    public static class NoteCard {
        public static final By TEXT_LOCATOR = By.className("feed_b");

        public final SelenideElement selenideElement;

        public NoteCard(SelenideElement selenideElement) {
            this.selenideElement = selenideElement;
        }

        public static List<NoteCard> getNotes(List<SelenideElement> elements) {
            if (elements.isEmpty()) {
                return Collections.emptyList();
            }
            List<NoteCard> noteCardList = new ArrayList<>();
            for (SelenideElement selenideElement : elements) {
                noteCardList.add(new NoteCard(selenideElement));
            }
            return noteCardList;
        }

        public void checkNoteText(String expectedText) {
            assertThat(expectedText, equalTo(
                selenideElement
                    .find(TEXT_LOCATOR)
                    .text()));
        }
    }

    public static class PostLayer extends BasePage {
        private static final By WRITE_NOTE_TEXT_FIELD_LOCATOR =
            By.xpath(".//div[contains(@class, 'posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler')]");
        private static final By SAVE_BUTTON_LOCATOR = By.xpath(".//div[contains(@data-save, 'Сохранить')]");

        @Override
        protected void check() {
            $(WRITE_NOTE_TEXT_FIELD_LOCATOR).shouldBe(Condition.visible);
        }

        public PostLayer writeText(String text) {
            $(WRITE_NOTE_TEXT_FIELD_LOCATOR).sendKeys(text);
            return this;
        }

        public PostLayer shareAndExit() {
            $(SAVE_BUTTON_LOCATOR)
                .shouldBe(Condition.visible)
                .click();
            return this;
        }
    }

    private static final By NOTE_ALERT_BUTTON =
        By.xpath(".//div[contains(@data-l, 't,feed.posting.ui.input')]");
    private static final By NOTES_LIST =
        By.xpath(".//div[contains(@class, 'media_feed user-statuses')]//div[@class='feed']");

    @Override
    protected void check() {
        $(NOTE_ALERT_BUTTON).shouldBe(Condition.visible);
    }

    public NotePage createNote(String text) {
        $(NOTE_ALERT_BUTTON).click();
        new PostLayer()
            .writeText(text)
            .shareAndExit();
        sleep(1000);
        return this;
    }

    public NotePage checkLastNote(String expectedTest) {
        NoteCard.getNotes($$(NOTES_LIST)).get(0).checkNoteText(expectedTest);
        return this;
    }
}
