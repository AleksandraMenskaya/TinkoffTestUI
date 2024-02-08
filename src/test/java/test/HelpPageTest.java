package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HelpPage;

public class HelpPageTest extends TestBaseTinkoff {
    private pages.HelpPage helpPage = new HelpPage();
    @Tag("HelpPageTest")
    @DisplayName("Первый элемент поисковой выдачи содержит текст запроса")
    @ParameterizedTest(name = "Если искать {0}, то первый элемент в поисковой выдачи будет {0}")
    @ValueSource(strings = {
            "Как скачать приложение",
            "Как написать в чат",
            "Кэшбэк",
            "Перевод"
    })
    void checkOutPut (String textSearch) {
        helpPage.openHelpPage()
        .clickSearchBar()
        .setSearchBar(textSearch)
        .validationSearchText(textSearch);
    }

    @DisplayName("Отправка оценки")
    @Tag("HelpPageTest")
    @Tag("positive")
    @Test
    void feedbackSend () {
        helpPage.openHelpPage()
                .scrollToFeedbackButton()
                .clickFeedbackButton()
                .checkAnswerModalWindowText("Была ли полезна страница?")
                .clickUpvoteButton()
                .clickSkipButton()
                .checkThankYouText("Спасибо");
    }
}
