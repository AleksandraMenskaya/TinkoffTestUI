package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class HelpPageTest extends TestBaseTinkoff {

    @Tag("SearchTest")
    @DisplayName("Первый элемент поисковой выдачи содержит текст запроса")
    @ParameterizedTest(name = "Если искать {0}, то первый элемент в поисковой выдачи будет {0}")
    @ValueSource(strings = {
            "Как скачать приложение",
            "Как написать в чат",
            "Кэшбэк",
            "Перевод"
    })
    void checkOutPut(String textSearch){
        open("/help/");
        $("[data-qa-type=\"uikit/popover.children\"]").click();
        $("[data-qa-type=\"uikit/popover.children\"] input[type=\"text\"]").setValue(textSearch).pressEnter();
        $("[data-qa-type=\"uikit/dropdown.item\"]").shouldHave(text(textSearch));
    }

    // проверка кнопки ответить внизу страницы
    // скоролл к кнопке
    //клик
    // проверка открытия модалки
    // выставление оценки полож
    // текстовое поле + отправить
    // Спасибо за обратную связь!
}
