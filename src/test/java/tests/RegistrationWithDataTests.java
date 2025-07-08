package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setPhone(data.userPhone)
                .setCurrentAddress(data.userCurrentAddress)
                .setGender(data.userGender)
                .setDateOfBirth(data.day, data.month, data.year)
                .setSubject(data.userSubject)
                .setHobbies(data.userHobbies)
                .uploadPicture(data.userPicture)
                .setState(data.userState)
                .setCity(data.userCity)
                .clickSubmit();


        registrationPage.verifyResultsModalAppears(data.modalTitle)
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.userGender)
                .verifyResult("Mobile", data.userPhone)
                .verifyResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .verifyResult("Subjects", data.userSubject)
                .verifyResult("Hobbies", data.userHobbies)
                .verifyResult("Picture", data.userPicture)
                .verifyResult("Address", data.userCurrentAddress)
                .verifyResult("State and City", data.userState + " " + data.userCity);
    }


    @Test
    void successfulRegistrationMinimalTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.userGender)
                .setPhone(data.userPhone)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears(data.modalTitle)
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Gender", data.userGender)
                .verifyResult("Mobile", data.userPhone);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .hideAd()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.userGender)
                .clickSubmit();

        registrationPage.verifyResultsModalNotAppears();
    }
}