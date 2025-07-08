package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    public Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userPhone = faker.phoneNumber().subscriberNumber(10);
    public String userCurrentAddress = faker.address().fullAddress();
    public String userGender = faker.options().option("Male", "Female", "Other");
    public String userSubject = faker.options().option("Arts", "Physics", "English", "History", "Maths", "Biology");
    public String userHobbies = faker.options().option("Sports", "Reading", "Music");
    public String userPicture = faker.options().option("картинка1.jpg", "картинка2.jpg");
    public String day = String.format("%02d", faker.number().numberBetween(1, 29));
    public String month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December");
    public String year = String.format("%s", faker.number().numberBetween(1920, 2024));
    public String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String userCity = getCityForState(userState);


    private String getCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public String modalTitle = "Thanks for submitting the form";
}
