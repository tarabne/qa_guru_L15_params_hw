package ru.tarabne.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(int day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        if (day >= 1 && day <= 9) {
            $(".react-datepicker__day--00" + String.valueOf(day) + ":not(.react-datepicker__day--outside-month").click();
        }
        else
            $(".react-datepicker__day--0" + String.valueOf(day) + ":not(.react-datepicker__day--outside-month").click();
    }
}
