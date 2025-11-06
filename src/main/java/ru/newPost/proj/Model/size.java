package ru.newPost.proj.Model;

public enum size {

    SMALL ("260x175x95"),
    MEDIUM ("300x200x150"),
    LARGE ("400x270x180"),
    HUGE ("530x360x220");

    private String title;

    size(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
