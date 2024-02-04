package test;

import data.BirthdayArgumentProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.ParameterizedTest;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import data.URLsDesignCard;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.provider.ValueSource;

public class FormDebitCardTest extends TestBaseTinkoff {

    @Tag("FormDebitCardTest")
    @Tag("Positive_test")
    @DisplayName("Валидация поля Дата рождения")
    @ArgumentsSource(BirthdayArgumentProvider.class)
    @ParameterizedTest(name = "Для даты {0} текст валидации должен быть {1}")
    void successfulSendFormForDebitCard(String birthday, String ValidationText) {
        open("/cards/debit-cards/tinkoff-black/");
        $("#form").scrollIntoView(true);
        $("div[data-qa-type=\"uikit/input.inputBox.main\"").click();
        $("input[name=\"birthdate\"]").setValue(birthday).pressEnter();
        $("div[data-qa-type=\"uikit/formRow.errorBlock\"]").shouldHave(exactText(ValidationText));
    }

    @DisplayName("Проверка дизайнов карты")
    @Tag("FormForDebitCard")
    @Tag("positive")
    @ValueSource(strings = {
            "/cards/debit-cards/tinkoff-black/",
            "/cards/debit-cards/tinkoff-black/foreign/eng/"
    })
    @ParameterizedTest(name = "Для url {0} отображаются правильные дизайна карт")
    void checkChangeImage (String UrlPage) {
        Pair<String, String>[] URLs = (new URLsDesignCard()).URLs;

        open(UrlPage);
        $("#form").scrollIntoView(true);
        checkFullAndPreview(URLs[3].getRight(), URLs[3].getLeft());

        for (Pair<String,String> PairURL: URLs){
            clickPreview (PairURL.getLeft());
            checkFullAndPreview(PairURL.getRight(), PairURL.getLeft());
        }
    }
    private void checkFullAndPreview(String full, String preview){
        $("[data-qa-type=\"uikit/individualDesign.selectedCard\"] img").shouldHave(attribute("src",full));
        $("[data-qa-type=\"uikit/individualDesign.previewSelected\"] img").shouldHave(attribute("src",preview));
    }
    private void clickPreview (String preview){
        $("[data-qa-type=\"uikit/individualDesign.preview\"] img[src=\"" + preview + "\"]").click();
    }

    //тест-кейс Заполнение прогресс бара
    // скоролл
    // проверка  %
    // заполнение поля фио
    // проверка 25 %
    // заполнение даты рождения
    // проверка 40 %


    //валидация электронной почты

//   Пустое поле
//Превышение длины локальной части (максимальная допустимая 64 символа)
//Превышение длины доменного имени (максимальная допустимая 255 символов)
//Превышение длины участка доменного имени между точками (максимальная допустимая 63 символа)
//Отсутствие @ в email
//Отсутствие локальной части
//Отсутствие доменной части
//Содержит две точки подряд
//Локальная часть начинается с . (точки)
//Доменная часть начинается с . (точки)
    //проверка ошибки

}
