package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class DemographyTargetingTest extends TestBaseTinkoff {

    @Tag("DemographyTargetingTest")
    @Tag("Positive_test")
    @DisplayName("Проверка перехода при указание возраста при оформление карты")
    @CsvSource(value = {
            "0, Дебетовую Tinkoff Black можно получить с 14 лет. Копи и получай кэшбэк до 30% за покупки",
            "1, Получайте кэшбэк в рублях за траты в ресторанах, кино, супермаркетах, магазинах одежды",
            "2, Получайте кэшбэк рублями, а не бонусами за покупки для всей семьи и только для себя. Оплачивайте ЖКУ и другие услуги без комиссии",
            "3, Возвращаем до 15% за продукты, товары для здоровья и дома. Без комиссии за снятие наличных в банкоматах Тинькофф, оплата ЖКУ и связи"
    })
    @ParameterizedTest(name = "Для cssSelector {0} текст заголовка должен быть {1}")
    void CheckAgeText (int index, String ValidationText) {
        open("/cards/debit-cards/tinkoff-black/");
        $$("[data-qa-type=\"uikit/radio.input\"]").get(index).click();
        $$("[data-qa-type=\"uikit/button.content\"]").findBy(text("Настроить карту для вас")).click();
        $("[data-test=\"htmlTag subtitle\"]").shouldHave(text(ValidationText));
    }
}
