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
import pages.DebitCardFormPage;
import static io.qameta.allure.Allure.step;

public class FormDebitCardTest extends TestBaseTinkoff {

    private DebitCardFormPage DebitCardFormPage = new DebitCardFormPage();

    @Tag("FormDebitCardTest")
    @Tag("AllTest")
    @DisplayName("Валидация поля Дата рождения")
    @ArgumentsSource(BirthdayArgumentProvider.class)
    @ParameterizedTest(name = "Для даты {0} текст валидации должен быть {1}")
    void validationBirthdayField (String birthday, String ValidationText) {
        step("Открываем страницу tinkoff black", () -> {
        DebitCardFormPage.openRusBlackCardPage();
        });
        step("Скролим к форме", () -> {
            DebitCardFormPage.scrollToForm();
        });
        step("Вводим значение в поле Дата рождения", () -> {
            DebitCardFormPage.clickBirthdayField()
                    .setBirthdayField(birthday);
        });
        step("Валидируем значение в поле Дата рождения", () -> {
            DebitCardFormPage.validationFieldText(ValidationText);;
        });
    }

    @DisplayName("Проверка дизайнов карты")
    @Tag("FormDebitCardTest")
    @Tag("AllTest")
    @ValueSource(strings = {
            "/cards/debit-cards/tinkoff-black",
            "/cards/debit-cards/tinkoff-black/foreign/eng"
    })
    @ParameterizedTest(name = "Для url {0} отображаются правильные дизайна карт")
    void checkChangeImage (String URL) {
         Pair[] URLs = (new URLsDesignCard()).URLs;
         step("Открываем страницу tinkoff black", () -> {
         DebitCardFormPage.openLocalBlackCardPage(URL);
         });
         step("Скролим к форме", () -> {
         DebitCardFormPage.scrollToForm();
        });
        step("Проверяем дефолтное превью карты", () -> {
            DebitCardFormPage.checkPreview(URLs[3].full, URLs[3].preview);
        });
        step("Проверяем выбора дизайна карты [0]", () -> {
        DebitCardFormPage.clickPreview(URLs[0].preview)
                         .checkPreview(URLs[0].full, URLs[0].preview);
        });
        step("Проверяем выбора дизайна карты [1]", () -> {
        DebitCardFormPage.clickPreview(URLs[1].preview)
                         .checkPreview(URLs[1].full, URLs[1].preview);
        });
        step("Проверяем выбора дизайна карты [2]", () -> {
        DebitCardFormPage.clickPreview(URLs[2].preview)
                          .checkPreview(URLs[2].full, URLs[2].preview);
        });
        step("Проверяем выбора дизайна карты [3]", () -> {
        DebitCardFormPage.clickPreview(URLs[3].preview)
                         .checkPreview(URLs[3].full, URLs[3].preview);
        });
    }

    @DisplayName("Валидация заполнения прогресс бара")
    @Tag("FormDebitCardTest")
    @Tag("AllTest")
    @Test
    void checkProgressBar () {
        step("Открываем страницу tinkoff black", () -> {
        DebitCardFormPage.openRusBlackCardPage();
        });
        step("Скролим к форме", () -> {
        DebitCardFormPage.scrollToForm();
        });
        step("Проверяем, что значение в прогресс баре равно 5%", () -> {
        DebitCardFormPage.checkProgressBar("5%");
        });
        step("Проверяем, что значение в прогресс баре равно 25% при заполнение поля ФИО", () -> {
        DebitCardFormPage.clickFioField()
                         .fillFioField("Иванов Иван")
                         .checkProgressBar("25%");
        });
        step("Проверяем, что значение в прогресс баре равно 45% при заполнение поля телефон", () -> {
        DebitCardFormPage.clickMobileField()
                         .fillMobileField("9875632405")
                         .checkProgressBar("45%");
        });
        step("Проверяем, что значение в прогресс баре равно 60% при заполнение поля дата рождения", () -> {
        DebitCardFormPage.clickBirthdayField()
                         .setBirthdayField("02.08.1988")
                         .checkProgressBar("60%");
        });
    }

    @DisplayName("Валидация поля электронная почта")
    @Tag("FormDebitCardTest")
    @Tag("AllTest")
    @ValueSource(strings = {
            "emailemail.com",
            "@email.com",
            "email@.com",
            "email@email..com",
            "email@.email.com"
    })
    @ParameterizedTest(name = "Для email {0} отображаются ошибка валидации")
    void validationEmailField (String email) {
        step("Открываем страницу tinkoff black", () -> {
        DebitCardFormPage.openRusBlackCardPage();
        });
        step("Скролим к форме", () -> {
        DebitCardFormPage.scrollToForm();
        });
        step("Проверяем ошибку валидации", () -> {
        DebitCardFormPage.clickEmailField()
                         .fillEmailField(email)
                         .validationFieldText("Проверьте адрес электронной почты");
        });
    }
    @DisplayName("Скролл к форме карты Tinkoff Black")
    @Tag("FormDebitCardTest")
    @Tag("AllTest")
    @Test
    void checkTitleForm () {
        step("Открываем страницу tinkoff black", () -> {
        DebitCardFormPage.openRusBlackCardPage();
        });
        step("Проверяем скролл к форме tinkoff black по клику на кнопку Оформита карту", () -> {
        DebitCardFormPage.transitionToForm()
                         .checkTitleForm("Получите Tinkoff Black уже сегодня");
        });
    }
}


