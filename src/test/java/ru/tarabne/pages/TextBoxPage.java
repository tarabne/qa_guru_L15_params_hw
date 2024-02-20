package ru.tarabne.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmailInput(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();

        return this;
    }

    public TextBoxPage nameCheck(String name) {
        resultName.shouldHave(text("Name:" + name));

        return this;
    }

    public TextBoxPage emailCheck(String email) {
        resultEmail.shouldHave(text("Email:" + email));

        return this;
    }

    public TextBoxPage currentAddressCheck(String currentAddress) {
        resultCurrentAddress.shouldHave(text("Current Address :" + currentAddress));

        return this;
    }

    public TextBoxPage permanentAddressCheck(String permanentAddress) {
        resultPermanentAddress.shouldHave(text("Permananet Address :" + permanentAddress));

        return this;
    }

}
