package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DebitCardLocalPage {
    public SelenideElement
            headerBlock = $("div[class=\"application\"] [data-test=\"htmlTag title\"]");

    public DebitCardLocalPage openLocalPage (String URL) {
        open(URL);
        return this;
    }

    public DebitCardLocalPage validationHeaderText (String validationText) {
        headerBlock.shouldHave(text(validationText));
        return this;
    }

}

