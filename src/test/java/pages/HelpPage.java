package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HelpPage {
    public SelenideElement

        titleName = $(By.xpath("//h2/*[text()='Страхование']")),
        firstSuggest = $("[data-testid=\"container\"] h1"),
        feedbackButton = $(By.xpath("//button[@data-qa-type='uikit/button'][descendant::*[text()='Ответить']]")),
        feedbackIframe = $("[data-test='iframeContainer'] iframe"),
        textModalWindow = $(By.xpath("//*[text()='Была ли полезна страница?']")),
        likeImg = $("[alt=\"like\"]"),
        skipButton = $(By.xpath("//button[text()='Пропустить']")),
        thankYouText = $("p");

    private SelenideElement getBlock(String title) {
        String template = "//a[@data-qa-type='uikit/clickable'][descendant::p[text()='%1$s']]";
        String xPath = String.format(template, title);
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
        titleName.scrollIntoView(false);
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
