package ru.tarabne.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public void checkResultsTable(String field, String value) {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText(field)).parent()
                .shouldHave(text(value));
    }
}
