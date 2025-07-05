package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxResults {

    private final SelenideElement fullNameInput = $("#output #name"),
            emailInput = $("#output #email"),
            currentAddressInput = $("#output #currentAddress"),
            permanentAddressInput = $("#output #permanentAddress");

    public void checkFullName(String value) {
        fullNameInput.shouldHave(text(value));
    }

    public void checkEmail(String value) {
        emailInput.shouldHave(text(value));
    }

    public void checkCurrentAddress(String value) {
        currentAddressInput.shouldHave(text(value));
    }

    public void checkPermanentAddress(String value) {
        permanentAddressInput.shouldHave(text(value));
    }
}