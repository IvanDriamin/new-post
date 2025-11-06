package ru.newPost.proj.Model;

public enum package_type {

    LETTER ("letter"),
    WRAPPER ("wrapper"),
    BOX ("box");

    private String title;

    package_type(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
