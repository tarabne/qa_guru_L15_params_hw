package ru.tarabne.testdata;

import com.github.javafaker.Faker;

public class RegistrationTestData {
    static Faker faker = new Faker();
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(genders),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            invalidPhoneNumber = faker.phoneNumber().subscriberNumber(9),
            birthdayMonth = faker.options().option(months),
            birthdayYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            subject = faker.options().option(subjects),
            hobby = faker.options().option(hobbies),
            picture = faker.options().option(pictures),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option(states),
            city = getRandomCity(state);
    public int birthdayDay = faker.number().numberBetween(1, 28);

    static String[] months = {"January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    static String[] subjects = {"Maths", "Chemistry", "Computer Science",
            "Accounting", "Arts", "Social Studies", "History"};
    static String[] hobbies = {"Sports", "Reading", "Music"};
    static String[] pictures = {"1.jpeg", "2.jpeg", "3.jpeg"};
    static String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    static String[] genders = {"Male", "Female", "Other"};

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi","Gurgaon","Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra","Lucknow","Merrut");
            case "Haryana":
                return faker.options().option("Karnal","Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur","Jaiselmer");
        }
        return state;
    }
}