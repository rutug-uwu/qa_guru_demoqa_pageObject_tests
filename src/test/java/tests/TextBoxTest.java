package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Ivanov Ivan")
                .setUserEmail("Qaguru@test.com")
                .setCurrentAddress("some street 123")
                .setPermanentAddress("another street 123")
                .clickSubmit();


        textBoxPage.checkResult("Ivanov Ivan", "Qaguru@test.com", "some street 123", "another street 123");
    }
}

