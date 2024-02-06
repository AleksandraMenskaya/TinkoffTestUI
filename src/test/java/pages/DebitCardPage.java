package pages;



import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DebitCardPage {
    public SelenideElement formBlock =  $("#form"),
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
            progressBar = $("[data-qa-type=\"uikit/sidebar.subtitle\"]");


    public DebitCardPage openURL(String URL) {
        open(URL);
        return this;
    }
    public DebitCardPage openRusPage() {
        open("/cards/debit-cards/tinkoff-black/");
        return this;
    }
     public SelenideElement getIndividualDesignPreview (String preview) {
         return $("[data-qa-type=\"uikit/individualDesign.preview\"] img[src=\"" + preview + "\"]");
     }
     public DebitCardPage scrollToForm (){
         formBlock.scrollIntoView(true);
         return this;
     }
     public DebitCardPage clickBirthdayField(){
         birthdayInputWrapper.click();
         return this;
     }
    public DebitCardPage setBirthdayField (String birthday) {
        birthdayInputField.setValue(birthday).pressEnter();
        return this;
    }
    public DebitCardPage validationFieldText (String validationText) {
        errorBlock.shouldHave(exactText(validationText));
        return this;
    }
    public DebitCardPage clickPreview (String preview) {
        getIndividualDesignPreview(preview).click();
        return this;
    }
    public DebitCardPage checkPreview (String full, String preview) {
        selectedCard.shouldHave(attribute("src",full));
        previewSelected.shouldHave(attribute("src",preview));
        return this;
    }
    public DebitCardPage checkProgressBar (String validationText) {
        progressBar.shouldHave(exactText(validationText));
        return this;
    }
    public DebitCardPage clickFioField () {
        fioClick.click();
        return this;
    }
    public DebitCardPage fillFioField (String value) {
        fioInput.setValue(value);
        fioInput.pressEnter();
        return this;
    }
    public DebitCardPage clickMobileField () {
        mobilePhoneClick.click();
        return this;
    }
    public DebitCardPage fillMobileField (String value) {
        mobilePhoneInput.setValue(value);
        mobilePhoneInput.pressEnter();
        return this;
    }
    public DebitCardPage clickEmailField () {
        emailWrapper.click();
        return this;
    }
    public DebitCardPage fillEmailField (String value) {
        emailInput.setValue(value);
        emailInput.pressEnter();
        return this;
    }

//    public DebitCardPage clearEmail () {
//        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        return this;
//    }
}