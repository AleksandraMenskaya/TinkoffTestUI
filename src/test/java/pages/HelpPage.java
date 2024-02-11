package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HelpPage {
    public SelenideElement
        searchBarWrapper = $("[data-qa-type=\"uikit/popover.children\"]"),
        searchBarInput = $("[data-qa-type=\"uikit/popover.children\"] input[type=\"text\"]"),
        firstSuggest = $("[data-qa-type=\"uikit/dropdown.item\"]"),
        feedbackButton = $(By.xpath("//button[@data-qa-type='uikit/button'][descendant::*[text()='Ответить']]")),
        feedbackIframe = $("[data-test='iframeContainer'] iframe"),
        textModalWindow = $(By.xpath("//*[text()='Была ли полезна страница?']")),
        likeImg = $("[alt=\"like\"]"),
        skipButton = $(By.xpath("//button[text()='Пропустить']")),
        thankYouText = $("p");

    public HelpPage openHelpPage() {
        open("/help/");
        return this;
    }
    public HelpPage scrollToFeedbackButton (){
        feedbackButton.scrollIntoView(true);
        executeJavaScript("scroll(0, 50);"); //сдвиг для устранения перекрытия плавающим хедером
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
    public HelpPage clickSearchBar(){
        searchBarWrapper.click();
        return this;
    }
    public HelpPage setSearchBar (String textSearch) {
        searchBarInput.setValue(textSearch).pressEnter();
        Configuration.timeout = 5000;
        return this;
    }
    public HelpPage validationSearchText (String validationText) {
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
}
