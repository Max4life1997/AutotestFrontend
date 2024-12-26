
import io.qameta.allure.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


@Slf4j
public class TextBoxTest extends BaseTest {

    private TextBoxPage textBoxPage;

    @BeforeEach
    void baseStep() {
        textBoxPage = new TextBoxPage().openPage();
    }


    @Test
    @Tag("UI")
    @DisplayName("Тест название")
    @Owner("Max")
    void test1() {
        log.info("Hello");
        textBoxPage
                .fillForm("Max", "Maxgmail.com", "SPB", "SPB2")
                .checkForm("Max", "Max@gmail.com", "SPB", "SPB2");
    }

    @AfterEach
    public void attachLogsToAllure() {

    }
}
