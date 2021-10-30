package sources;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class Utils {

    public static void sendKeysWithDeleteOldValue(SelenideElement selenideElement, final String keys) {
        final String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        selenideElement.sendKeys(deleteString);
        selenideElement.sendKeys(keys);
    }
}
