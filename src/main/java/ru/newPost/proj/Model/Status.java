package ru.newPost.proj.Model;

public enum Status {
    STATED ("Принята предварительная заявка"),
    ACCEPTED ("Принято в доставку"),
    TRANSIT ("Доставляется"),
    AWAITING ("Ожидает получения"),
    RECEIVED ("Получено"),
    LOST ("Утеряно"),
    EXPIRED ("Не получено в срок");

    private String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
