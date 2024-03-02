package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HelpPage;

import static io.qameta.allure.Allure.step;

public class HelpPageTest extends TestBase {
    private pages.HelpPage helpPage = new HelpPage();

    @DisplayName("Отправка оценки")
    @Tag("HelpPageTest")
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
