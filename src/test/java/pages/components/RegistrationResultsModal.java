package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private final SelenideElement modalWindow = $(".modal-dialog"),
            modalTitle = $(".modal-content"),
            modalResult = $(".table-responsive");

    public void verifyModalAppears(String value) {
        modalWindow.should(appear);
        modalTitle.shouldHave(text(value));
    }

    public void verifyResult(String key, String value) {
        modalResult.$(byText(key))
                .parent().shouldHave(text(value));
    }

    public void verifyModalAppearsNegativ() {
        modalTitle.shouldNot();
    }
}