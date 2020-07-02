package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardTest {
    DataGenerator dataGenerator = new DataGenerator();
    String name = dataGenerator.nameByCard();
    String city = dataGenerator.getRandomCity();
    String phone = dataGenerator.getPhone();
    SelenideElement form = $("form[class='form form_size_m form_theme_alfa-on-white']");

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void submitRequest() {

        form.$("[placeholder='Город']").setValue(city);
        form.$("[placeholder='Дата встречи']").doubleClick().sendKeys(dataGenerator.forwardDate(3));
        form.$("[data-test-id=name] input").setValue(name);
        form.$("[name=phone]").setValue(phone);
        form.$(".checkbox__box").click();
        $(".button__text").click();
        $(withText("Успешно")).shouldBe(visible);

        open("http://localhost:9999");
        form.$("[placeholder='Город']").setValue(city);
        form.$("[placeholder='Дата встречи']").doubleClick().sendKeys(dataGenerator.forwardDate(4));
        form.$("[name=name]").setValue(name);
        form.$("[name=phone]").setValue(phone);
        form.$(".checkbox__box").click();
        $(".button__text").click();
        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).shouldBe(visible);
        $("[data-test-id=replan-notification] button.button").click();
        $(withText("Успешно")).shouldBe(visible);
    }
}
