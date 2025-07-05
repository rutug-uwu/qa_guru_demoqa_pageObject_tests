package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName("Ivan")
                .setSecondName("Ivanov")
                .setEmail("Ivanov@123.com")
                .setPhone("89999990000")
                .setCurrentAddress("Some address 123")
                .setGender()
                .setDateOfBirth("24", "February", "1999")
                .setSubject("Physics")
                .setSubject("English")
                .setHobbies()
                .uploadPicture("Img/photo_2022-12-19_20-56-33.jpg")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears("Thanks for submitting the form")
                .verifyResult("Student Name", "Ivan Ivanov")
                .verifyResult("Student Email", "Ivanov@123.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8999999000")
                .verifyResult("Date of Birth", "24 February,1999")
                .verifyResult("Subjects", "Physics, English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "photo_2022-12-19_20-56-33.jpg")
                .verifyResult("Address", "Some address 123")
                .verifyResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulRegistrationMinimalTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName("Oleg")
                .setSecondName("Olegov")
                .setGender()
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
                .setSecondName("Olegov")
                .setGender()
                .setPhone("8777777777")
                .clickSubmit();

        registrationPage.verifyResultsModalNotAppears();
    }
}