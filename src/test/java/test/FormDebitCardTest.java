package test;

import data.BirthdayArgumentProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.ParameterizedTest;
import data.URLsDesignCard;
import data.Pair;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DebitCardPage;

public class FormDebitCardTest extends TestBaseTinkoff {

    private DebitCardPage DebitCardPage = new DebitCardPage();

    @Tag("FormDebitCardTest")
    @Tag("Positive_test")
    @DisplayName("Валидация поля Дата рождения")
    @ArgumentsSource(BirthdayArgumentProvider.class)
    @ParameterizedTest(name = "Для даты {0} текст валидации должен быть {1}")
    void validationBirthdayField (String birthday, String ValidationText) {
        DebitCardPage.openRusPage()
        .scrollToForm()
        .clickBirthdayField()
        .setBirthdayField(birthday)
        .validationFieldText(ValidationText);
    }

    @DisplayName("Проверка дизайнов карты")
    @Tag("FormDebitCardTest")
    @Tag("positive")
    @ValueSource(strings = {
            "/cards/debit-cards/tinkoff-black",
            "/cards/debit-cards/tinkoff-black/foreign/eng"
    })
    @ParameterizedTest(name = "Для url {0} отображаются правильные дизайна карт")
    void checkChangeImage (String UrlPage) {
         Pair[] URLs = (new URLsDesignCard()).URLs;

         DebitCardPage.openURL(UrlPage)
            .scrollToForm()
            .checkPreview(URLs[3].full, URLs[3].preview)
            .clickPreview(URLs[0].preview)
            .checkPreview(URLs[0].full, URLs[0].preview)
            .clickPreview(URLs[1].preview)
            .checkPreview(URLs[1].full, URLs[1].preview)
            .clickPreview(URLs[2].preview)
            .checkPreview(URLs[2].full, URLs[2].preview)
            .clickPreview(URLs[3].preview)
            .checkPreview(URLs[3].full, URLs[3].preview);
    }

    @DisplayName("Валидация заполнения прогресс бара")
    @Tag("FormDebitCardTest")
    @Tag("positive")
    @Test
    void checkProgressBar () {
        DebitCardPage.openRusPage()
        .scrollToForm()
        .checkProgressBar("5%")
        .clickFioField()
        .fillFioField("Иванов Иван")
        .checkProgressBar("25%")
        .clickMobileField()
        .fillMobileField("9875632405")
        .checkProgressBar("45%")
        .clickBirthdayField()
        .setBirthdayField("02.08.1988")
        .checkProgressBar("60%");
    }

    @DisplayName("Валидация поля электронная почта")
    @Tag("FormDebitCardTest")
    @Tag("negative")
    @ValueSource(strings = {
            "emailemail.com",
            "@email.com",
            "email@.com",
            "email@email..com",
            "email@.email.com"
    })
    @ParameterizedTest(name = "Для email {0} отображаются ошибка валидации")
    void validationEmailField (String email) {
        DebitCardPage.openRusPage()
                .scrollToForm()
                .clickEmailField()
                .fillEmailField(email)
                .validationFieldText("Проверьте адрес электронной почты");
    }
}


