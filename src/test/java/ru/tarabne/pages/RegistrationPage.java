package ru.tarabne.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.tarabne.pages.components.CalendarComponent;
import ru.tarabne.pages.components.FileUploaderComponent;
import ru.tarabne.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            statesList = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            citiesList = $("#city"),
            submitButton = $("#submit"),
            modalContent = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();
    FileUploaderComponent fileUploaderComponent = new FileUploaderComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Step("Открыть страницу automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        sleep(3000);
        SelenideElement bannerRoot = $(".fc-consent-root");
        if (bannerRoot.isDisplayed()) {
            bannerRoot.$(byText("Consent")).click();
        }

        return this;
    }

    @Step ("Заполнить имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step ("Заполнить фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step ("Заполнить email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step ("Выбрать пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step ("Заполнить номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step ("Заполнить дату рождения")
    public RegistrationPage setDateOfBirth(int day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step ("Заполнить предметы")
    public  RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressTab();

        return this;
    }

    @Step ("Заполнить хобби")
    public  RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step ("Загрузить фотографию")
    public  RegistrationPage uploadPicture(String value) {
        fileUploaderComponent.uploadFile(value);

        return this;
    }

    @Step ("Заполнить текущий адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step ("Выбрать штат")
    public RegistrationPage setState(String value) {
        statesList.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step ("Выбрать город")
    public RegistrationPage setCity(String value) {
        citiesList.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step ("Нажать submit")
    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    @Step ("Проверить корректность сохраненных данных")
    public RegistrationPage checkResult(String field, String value) {
        resultTableComponent.checkResultsTable(field, value);

        return this;
    }

    @Step ("Проверить, что данные успешно сохранены")
    public RegistrationPage registrationSuccessCheck() {
        modalContent.shouldBe(visible);

        return this;
    }

    @Step ("Проверить, что данные не сохранены")
    public RegistrationPage registrationFailureCheck() {
        modalContent.shouldBe(hidden);

        return this;
    }

}