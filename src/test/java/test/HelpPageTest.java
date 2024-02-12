package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HelpPage;

import static io.qameta.allure.Allure.step;

public class HelpPageTest extends TestBaseTinkoff {
    private pages.HelpPage helpPage = new HelpPage();
    @Tag("HelpPageTest")
    @Tag("AllTest")
    @DisplayName("Проверка заголовков после редиректа из плашки подписки и сервисы")
    @ParameterizedTest(name = "Найти элемент на странице [0]")
    @ValueSource(strings = {
            "ОСАГО",
            "Каско"
    })
    void checkOutPut (String text) {
        step("Открываем страницу help", () -> {
            helpPage.openHelpPage();
        });
        step("Проверяем заголовки после редиректа", () -> {
            helpPage.scrollToTitle()
                    .сlickBlock(text)
                    .validationSearchText(text);
        });
    }

    @DisplayName("Отправка оценки")
    @Tag("HelpPageTest")
    @Tag("AllTest")
    @Test
    void feedbackSend () {
        step("Открываем страницу help", () -> {
            helpPage.openHelpPage();
        });
        step("Проверяем отображения в модальном окне надписи Была ли полезна страница?", () -> {
            helpPage.scrollToFeedbackButton()
                    .clickFeedbackButton()
                    .checkAnswerModalWindowText("Была ли полезна страница?");
        });
        step("Проверяем возможность выставить like ", () -> {
            helpPage.clickUpvoteButton();
        });
        step("Проверяем отображения в модальном окне надписи Спасибо", () -> {
            helpPage.clickSkipButton()
                    .checkThankYouText("Спасибо")
                    .setDefaultFrame() ;
        });
    }
}
