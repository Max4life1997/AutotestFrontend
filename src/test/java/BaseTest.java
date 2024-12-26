import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.Config;
import io.qameta.allure.Epic;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.AllureTestListener;

@Epic("Тестовый Эпик")
@ExtendWith(AllureTestListener.class)
class BaseTest {

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureTestListener", new AllureSelenide());

        // Установка базового URL
        Configuration.baseUrl = Config.getInstance("local").getProperty("selenide.base.url");

        // Указание браузера (например, Chrome, Firefox)
        Configuration.browser = Config.getInstance("local").getProperty("selenide.browser");

        // Задание времени ожидания (в миллисекундах)
        Configuration.timeout = Long.parseLong(Config.getInstance("local").getProperty("selenide.timeout"));

        // Включение/выключение автоматического закрытия браузера после тестов
        Configuration.holdBrowserOpen = Boolean.parseBoolean(Config.getInstance("local").getProperty("selenide.browser.holdBrowserOpen"));

        // Указание папки для сохранения скриншотов и отчетов
        Configuration.reportsFolder = Config.getInstance("local").getProperty("selenide.reportsFolder");

        // Если требуется запуск в headless режиме
        Configuration.headless = Boolean.parseBoolean(Config.getInstance("local").getProperty("selenide.browser.headless"));

        // Установка версии браузера
        Configuration.browserVersion = Config.getInstance("local").getProperty("selenide.browser.browserVersion");

        // Установка размера окна браузера
        Configuration.browserSize = Config.getInstance("local").getProperty("selenide.browser.browserSize");

        // Установка времени ожидания загрузки страницы
        Configuration.pageLoadTimeout = Long.parseLong(Config.getInstance("local").getProperty("selenide.browser.pageLoadTimeout"));

        // Включение быстрой установки значений в полях ввода
        Configuration.fastSetValue = Boolean.parseBoolean(Config.getInstance("local").getProperty("selenide.browser.fastSetValue"));

        // Включение логов WebDriver
        Configuration.webdriverLogsEnabled = Boolean.parseBoolean(Config.getInstance("local").getProperty("selenide.webdriverLogsEnabled"));

        // Указание папки для скачиваемых файлов
        Configuration.downloadsFolder = Config.getInstance("local").getProperty("selenide.downloadsFolder");

        // Включение/выключение скриншотов при ошибках
        Configuration.screenshots = Boolean.parseBoolean(Config.getInstance("local").getProperty("selenide.screenshots"));

        // Включение/выключение сохранения исходного кода страницы при ошибках
        Configuration.savePageSource = Boolean.parseBoolean(Config.getInstance("local").getProperty("selenide.savePageSource"));
    }

    @AfterAll
    static void cleanUp() {

    }
}
