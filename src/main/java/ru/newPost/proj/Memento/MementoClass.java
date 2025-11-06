package ru.newPost.proj.Memento;

public class MementoClass {
    private final int pack;

    public MementoClass(int pack) {
        this.pack = pack;
    }

    public int getSavedState() {
        return pack;
    }
}
