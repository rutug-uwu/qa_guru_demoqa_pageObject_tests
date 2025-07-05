package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            secondNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userPhoneInput = $("#userNumber"),
            userAddressInput = $("#currentAddress"),
            genderWrapper = $("#gender-radio-1"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbies-checkbox-1"),
            pictureInput = $("#uploadPicture"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage hideAd() {

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setSecondName(String value) {
        secondNameInput.setValue(value);

        return this;
    }


    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setPhone(String value) {
        userPhoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender() {
        genderWrapper.parent().click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies() {
        hobbiesInput.parent().click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();

    }

    public RegistrationPage verifyResultsModalAppears(String value) {
        registrationResultsModal.verifyModalAppears(value);

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public void verifyResultsModalNotAppears() {
        registrationResultsModal.verifyModalAppearsNegativ();

    }
}
