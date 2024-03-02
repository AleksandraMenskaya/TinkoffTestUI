package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardFormPage {
    private final SelenideElement formBlock =  $("#form"),
            fioClick = $("[data-qa-type=\"uikit/inputFio.inputBox.inputContainer\"]"),
            fioInput = $("[data-qa-type=\"uikit/inputFio.value.input\"]"),
            mobilePhoneClick = $("[data-qa-type=\"uikit/inputPhone.inputBox.inputContainer\"]"),
            mobilePhoneInput = $("[data-qa-type=\"uikit/inputPhone.value.input\"]"),
            birthdayInputWrapper = $("div[data-qa-type=\"uikit/input.inputBox.main\""),
            birthdayInputField = $("input[name=\"birthdate\"]"),
            emailWrapper = $("[data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]"),
            emailInput = $("[data-qa-type=\"uikit/inputAutocomplete.value.input\"]"),
            errorBlock = $("div[data-qa-type=\"uikit/formRow.errorBlock\"]"),
            selectedCard = $("[data-qa-type=\"uikit/individualDesign.selectedCard\"]  img"),
            previewSelected = $("[data-qa-type=\"uikit/individualDesign.previewSelected\"] img"),
            progressBar = $("[data-qa-type=\"uikit/sidebar.subtitle\"]"),
            scrollToFormButton = $(By.xpath("//button[@data-qa-type='uikit/button'][descendant::*[text()='Оформить карту']]")),
            titleForm = $("[id=\"form-header\"] [data-test=\"htmlTag title\"]");

     public SelenideElement getIndividualDesignPreview (String preview) {
         return $("[data-qa-type=\"uikit/individualDesign.preview\"] img[src=\"" + preview + "\"]");
     }
    public DebitCardFormPage openLocalBlackCardPage (String URL) {
        open(URL);
        return this;
    }
    public DebitCardFormPage openRusBlackCardPage() {
        open("/cards/debit-cards/tinkoff-black/");
        return this;
    }
     public DebitCardFormPage scrollToForm (){
         formBlock.scrollIntoView(true);
         return this;
     }
     public DebitCardFormPage clickBirthdayField(){
         birthdayInputWrapper.click();
         return this;
     }
    public DebitCardFormPage setBirthdayField (String birthday) {
        birthdayInputField.setValue(birthday).pressEnter();
        return this;
    }
    public DebitCardFormPage validationFieldText (String validationText) {
        errorBlock.shouldHave(exactText(validationText));
        return this;
    }
    public DebitCardFormPage clickPreview (String preview) {
        getIndividualDesignPreview(preview).click();
        return this;
    }
    public DebitCardFormPage checkPreview (String full, String preview) {
        selectedCard.shouldHave(attribute("src",full));
        previewSelected.shouldHave(attribute("src",preview));
        return this;
    }
    public DebitCardFormPage checkProgressBar (String validationText) {
        progressBar.shouldHave(exactText(validationText));
        return this;
    }
    public DebitCardFormPage clickFioField () {
        fioClick.click();
        return this;
    }
    public DebitCardFormPage fillFioField (String value) {
        fioInput.setValue(value);
        fioInput.pressEnter();
        return this;
    }
    public DebitCardFormPage clickMobileField () {
        mobilePhoneClick.click();
        return this;
    }
    public DebitCardFormPage fillMobileField (String value) {
        mobilePhoneInput.setValue(value);
        mobilePhoneInput.pressEnter();
        return this;
    }
    public DebitCardFormPage clickEmailField () {
        emailWrapper.click();
        return this;
    }
    public DebitCardFormPage fillEmailField (String value) {
        emailInput.setValue(value);
        emailInput.pressEnter();
        return this;
    }
    public DebitCardFormPage transitionToForm (){
        scrollToFormButton.click();
        return this;
    }
    public DebitCardFormPage checkTitleForm (String validationText) {
        titleForm.shouldHave(exactText(validationText));
        return this;
    }
}