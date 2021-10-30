package cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static final String BASE_URL = "http://ok.ru";

    @BeforeEach
    public void setUp() {
        open(BASE_URL);
    }

    @AfterEach
    public void closeAll() {
        closeWebDriver();
    }
}
