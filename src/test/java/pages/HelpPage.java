package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HelpPage {
    public SelenideElement


        titleBank = $(By.xpath("//h2/*[text()='Банк']")),
//        blockTinkoffBlack = $(By.xpath("//a[@data-qa-type='uikit/clickable'][descendant::*[text()='Tinkoff Black']]")),
//        blockTinkoffPlatinum = $(By.xpath("//a[@data-qa-type='uikit/clickable'][descendant::*[text()='Тинькофф Платинум']]")),
//        blockDepositsAndAccount = $(By.xpath("//a[@data-qa-type='uikit/clickable'][descendant::*[text()='Вклады и счета']]")),
        firstSuggest = $("[data-test=\"htmlTag title\"]"),
        feedbackButton = $(By.xpath("//button[@data-qa-type='uikit/button'][descendant::*[text()='Ответить']]")),
        feedbackIframe = $("[data-test='iframeContainer'] iframe"),
        textModalWindow = $(By.xpath("//*[text()='Была ли полезна страница?']")),
        likeImg = $("[alt=\"like\"]"),
        skipButton = $(By.xpath("//button[text()='Пропустить']")),
        thankYouText = $("p");

    private SelenideElement getBlock(String title) {
        String template = "//a[@data-qa-type='uikit/clickable'][descendant::*[text()='%1$s']]";
        String xPath = String.format(template, title);

        System.out.println("--------------------" + xPath);
        return $(By.xpath(xPath));
    }

    public HelpPage openHelpPage() {
        open("/help/");
        return this;
    }
    public HelpPage scrollToFeedbackButton (){
        feedbackButton.scrollIntoView(false);
        executeJavaScript("scrollBy(0, 100)"); //скролл для видимости кнопки
        return this;
    }
    public HelpPage clickUpvoteButton (){
        likeImg.click();
        return this;
    }
    public HelpPage clickFeedbackButton(){
        feedbackButton.click();
        return this;
    }

    public HelpPage scrollToTitle (){
        titleBank.scrollIntoView(true);
        return this;
    }

    public HelpPage сlickBlock(String title) {
        getBlock(title).click();
        return this;
    }

    public HelpPage validationSearchText(String validationText) {
        firstSuggest.shouldHave(text(validationText));
        return this;
    }
    public HelpPage checkAnswerModalWindowText (String validationText) {
        switchTo().frame(feedbackIframe);
        textModalWindow.shouldHave(text(validationText));
        return this;
    }
    public HelpPage clickSkipButton (){
        skipButton.click();
        return this;
    }
    public HelpPage checkThankYouText (String validationText) {
        thankYouText.shouldHave(text(validationText));
        return this;
    }
    public HelpPage setDefaultFrame() {
        switchTo().defaultContent();
        return this;
    }
}
