package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Ivanov@123.com")
                .setPhone("89999990000")
                .setCurrentAddress("Some address 123")
                .setGender("Male")
                .setDateOfBirth("24", "February", "1999")
                .setSubject("Physics")
                .setSubject("English")
                .setHobbies("Sports")
                .uploadPicture("картинка1.jpg")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();


        registrationPage.verifyResultsModalAppears("Thanks for submitting the form")
                .verifyResult("Student Name", "Ivan Ivanov")
                .verifyResult("Student Email", "Ivanov@123.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8999999000")
                .verifyResult("Date of Birth", "24 February,1999")
                .verifyResult("Subjects", "Physics, English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "картинка1.jpg")
                .verifyResult("Address", "Some address 123")
                .verifyResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulRegistrationMinimalTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName("Oleg")
                .setLastName("Olegov")
                .setGender("Male")
                .setPhone("8777777777")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears("Thanks for submitting the form")
                .verifyResult("Student Name", "Oleg Olegov")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8777777777");
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName("Oleg")
                .setLastName("Olegov")
                .setGender("Male")
                .clickSubmit();

        registrationPage.verifyResultsModalNotAppears();
    }
}