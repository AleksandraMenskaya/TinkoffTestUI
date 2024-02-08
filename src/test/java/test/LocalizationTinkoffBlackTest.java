package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.DebitCardLocalPage;

public class LocalizationTinkoffBlackTest extends TestBaseTinkoff {
    private DebitCardLocalPage debitCardPage = new DebitCardLocalPage();

    @Tag("LocalizationTinkoffBlackTest")
    @DisplayName("Локализация страницы для определенного url")
    @CsvSource(value = {
            "/cards/debit-cards/tinkoff-black/foreign/kg/ , Россияда жашоо жана иштөө үчүн ыңгайлуу карта",
            "/cards/debit-cards/tinkoff-black/foreign/uz/ , Rossiyada yashash va ishlash uchun qulay karta",
            "/cards/debit-cards/tinkoff-black/foreign/eng/ , Convenient card for your life and work in Russia",
            "/cards/debit-cards/tinkoff-black/foreign/am/ , Հարմար քարտ Ռուսաստանում ապրելու և աշխատելու համար",
            "/cards/debit-cards/tinkoff-black/foreign/tj/ , Корти қулай барои ҳаёт ва кор дар Русия",
    })
    @ParameterizedTest(name = "Для url {0} текст заголовка должен быть {1}")
    void CheckLanguage(String URL, String validationText) {
        debitCardPage.openLocalPage(URL)
        .validationHeaderText(validationText);
    }
}