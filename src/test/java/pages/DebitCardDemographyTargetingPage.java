package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DebitCardDemographyTargetingPage {
    public SelenideElement
            headerBlock = $("div[class=\"application\"] [data-test=\"htmlTag title\"]");
    //        $$("[data-qa-type=\"uikit/radio.input\"]").get(index).click();
//        $$("[data-qa-type=\"uikit/button.content\"]").findBy(text("Настроить карту для вас")).click();
//        $("[data-test=\"htmlTag subtitle\"]").shouldHave(text(ValidationText));

    public DebitCardDemographyTargetingPage openDemographyTargetingPage () {
        open("/cards/debit-cards/tinkoff-black");
        return this;
    }

//    public DebitCardDemographyTarglPage validationHeaderText (String validationText) {
//        headerBlock.shouldHave(text(validationText));
//        return this;
//    }

}

