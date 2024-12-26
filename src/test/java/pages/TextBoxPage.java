package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage extends BasePage {
    public SelenideElement pageTitleAs = $x("//div[@class='main-header' and text()='Text Box']").as("Заголовок страницы");

    public SelenideElement fullNameInputAs = $x("//input[@id='userName']").as("Поле ввода полного имени");

    public SelenideElement emailInputAs = $x("//input[@id='userEmail']").as("Поле ввода электронной почты");

    public SelenideElement currentAddressTextareaAs = $x("//textarea[@id='currentAddress']").as("Поле ввода текущего адреса");

    public SelenideElement permanentAddressTextareaAs = $x("//textarea[@id='permanentAddress']").as("Поле ввода постоянного адреса");

    public SelenideElement submitButtonAs = $x("//button[@id='submit']").as("Кнопка отправки формы");

    public SelenideElement outputBlockAs = $x("//div[@id='output']").as("Блок отображения результатов");

    public SelenideElement fullNameOutputAs = $x("//p[@id='name']").as("Результат полного имени");

    public SelenideElement emailOutputAs = $x("//p[@id='email']").as("Результат электронной почты");

    public SelenideElement currentAddressOutputAs = $x("//p[@id='currentAddress']").as("Результат текущего адреса");

    public SelenideElement permanentAddressOutputAs = $x("//p[@id='permanentAddress']").as("Результат постоянного адреса");

    @Override
    public TextBoxPage openPage() {
        open("/text-box");
        return new TextBoxPage();
    }

    @Step("Заполнение формы")
    public TextBoxPage fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        // Заполнение формы
        fullNameInputAs.setValue(fullName);
        emailInputAs.setValue(email);
        currentAddressTextareaAs.setValue(currentAddress);
        permanentAddressTextareaAs.setValue(permanentAddress);
        submitButtonAs.click();

        // Проверка результатов
        outputBlockAs.shouldBe(visible);
        fullNameOutputAs.shouldBe(visible).shouldHave(text("Name:" + fullName));
        emailOutputAs.shouldBe(visible).shouldHave(text("Email:" + email));
        currentAddressOutputAs.shouldBe(visible).shouldHave(text("Current Address :" + currentAddress));
        permanentAddressOutputAs.shouldBe(visible).shouldHave(text("Permananet Address :" + permanentAddress));
        return this;
    }

    @Step("Проверка формы")
    public TextBoxPage checkForm(String fullName, String email, String currentAddress, String permanentAddress) {
        outputBlockAs.shouldBe(visible);
        fullNameOutputAs.shouldBe(visible).shouldHave(text("Name:" + fullName));
        emailOutputAs.shouldBe(visible).shouldHave(text("Email:" + email));
        currentAddressOutputAs.shouldBe(visible).shouldHave(text("Current Address :" + currentAddress));
        permanentAddressOutputAs.shouldBe(visible).shouldHave(text("Permananet Address :" + permanentAddress));
        return this;
    }


}
