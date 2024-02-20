package ru.tarabne.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class FileUploaderComponent {
    public void uploadFile(String path) {
        $(".form-file-label").parent().$("input[type='file']")
                .uploadFromClasspath(path);
    }
}
