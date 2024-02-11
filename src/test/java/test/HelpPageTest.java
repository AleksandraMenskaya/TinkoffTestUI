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
    @DisplayName("Проверка, что первый элемент поисковой выдачи содержит текст запроса")
    @ParameterizedTest(name = "Если искать {0}, то первый элемент в поисковой выдачи будет {0}")
    @ValueSource(strings = {
            "Как скачать приложение",
            "Как написать в чат",
            "Кэшбэк",
            "Перевод"
    })
    void checkOutPut (String textSearch) {
        step("Открываем страницу help", () -> {
        helpPage.openHelpPage();
        });
        step("Проверяем, что первый элемент поисковой выдачи содержит текст запроса", () -> {
        helpPage.clickSearchBar()
                .setSearchBar(textSearch)
                .validationSearchText(textSearch);
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
                    .checkThankYouText("Спасибо");
        });
    }
}
