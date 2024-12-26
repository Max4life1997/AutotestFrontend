package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.io.IOException;
import java.util.Base64;

public class AllureUtils {

    @Attachment(value = "Тестовые логи", type = "text/plain")
    public static byte[] attachLogs(String message) {
        return message.getBytes();
    }

    @Attachment(value = "Скриншот при ошибке", type = "image/png")
    public static byte[] saveScreenshot() throws IOException {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        return Base64.getDecoder().decode(screenshotAsBase64);
    }
}