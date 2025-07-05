package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxResults;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            userCurrentAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    TextBoxResults textBoxResults = new TextBoxResults();

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        userCurrentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        userPermanentAddress.setValue(value);

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public TextBoxPage checkFullName(String value) {
        textBoxResults.checkFullName(value);

        return this;
    }

    public TextBoxPage checkEmail(String value) {
        textBoxResults.checkEmail(value);

        return this;
    }

    public TextBoxPage checkCurrentAddress(String value) {
        textBoxResults.checkCurrentAddress(value);

        return this;
    }

    public void checkPermanentAddress(String value) {
        textBoxResults.checkPermanentAddress(value);

    }
}
