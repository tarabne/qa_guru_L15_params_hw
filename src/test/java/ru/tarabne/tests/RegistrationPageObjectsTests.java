package ru.tarabne.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tarabne.pages.RegistrationPage;
import ru.tarabne.testdata.RegistrationTestData;

@DisplayName("Форма регистрации студента")
public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationTestData registrationTestData = new RegistrationTestData();

    @Test
    @Tag("simple")
    @DisplayName("Регистрация студента со всеми полями")
    void fillFullFormTest() {
        registrationPage.openPage()
                .setFirstName(registrationTestData.firstName)
                .setLastName(registrationTestData.lastName)
                .setEmail(registrationTestData.userEmail)
                .setGender(registrationTestData.userGender)
                .setUserNumber(registrationTestData.phoneNumber)
                .setDateOfBirth(registrationTestData.birthdayDay, registrationTestData.birthdayMonth, registrationTestData.birthdayYear)
                .setSubjects(registrationTestData.subject)
                .setHobbies(registrationTestData.hobby)
                .uploadPicture(registrationTestData.picture)
                .setCurrentAddress(registrationTestData.currentAddress)
                .setState(registrationTestData.state)
                .setCity(registrationTestData.city)
                .submit();

        registrationPage.checkResult("Student Name", registrationTestData.firstName + " " +
                        registrationTestData.lastName)
                .checkResult("Student Email", registrationTestData.userEmail)
                .checkResult("Gender", registrationTestData.userGender)
                .checkResult("Mobile", registrationTestData.phoneNumber)
                .checkResult("Date of Birth", registrationTestData.birthdayDay + " " +
                        registrationTestData.birthdayMonth + "," + registrationTestData.birthdayYear)
                .checkResult("Subjects", registrationTestData.subject)
                .checkResult("Hobbies", registrationTestData.hobby)
                .checkResult("Picture", registrationTestData.picture)
                .checkResult("Address", registrationTestData.currentAddress)
                .checkResult("State and City", registrationTestData.state +
                        " " + registrationTestData.city);
    }

    @Test
    @Tag("simple")
    @DisplayName("Регистрация студента с заполнением только обязательных полей")
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .setFirstName(registrationTestData.firstName)
                .setLastName(registrationTestData.lastName)
                .setGender(registrationTestData.userGender)
                .setUserNumber(registrationTestData.phoneNumber)
                .setDateOfBirth(registrationTestData.birthdayDay, registrationTestData.birthdayMonth, registrationTestData.birthdayYear)
                .submit();

        registrationPage.checkResult("Student Name", registrationTestData.firstName + " " +
                        registrationTestData.lastName)
                .checkResult("Student Email", "\t")
                .checkResult("Gender", registrationTestData.userGender)
                .checkResult("Mobile", registrationTestData.phoneNumber)
                .checkResult("Date of Birth", registrationTestData.birthdayDay + " " +
                        registrationTestData.birthdayMonth + "," + registrationTestData.birthdayYear)
                .checkResult("Subjects", "\t")
                .checkResult("Hobbies", "\t")
                .checkResult("Picture", "\t")
                .checkResult("Address", "\t")
                .checkResult("State and City", "\t")
                .registrationSuccessCheck();
    }

    @Test
    @Tag("simple")
    @DisplayName("Регистрация студента, не заполняя никаких полей")
    void allFieldsAreEmptyTest() {
        registrationPage.openPage()
                .submit();

        registrationPage.registrationFailureCheck();

    }

    @Test
    @Tag("simple")
    @DisplayName("Регистрация студента девятизначным номером телефона")
    void phone9DigitsTest() {
        registrationPage.openPage()
                .setFirstName(registrationTestData.firstName)
                .setLastName(registrationTestData.lastName)
                .setGender(registrationTestData.userGender)
                .setUserNumber(registrationTestData.invalidPhoneNumber)
                .submit();

        registrationPage.registrationFailureCheck();

    }
}