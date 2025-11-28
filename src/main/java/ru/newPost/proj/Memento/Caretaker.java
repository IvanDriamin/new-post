package ru.newPost.proj.Memento;

import java.util.ArrayList;
import java.util.List;

import ru.newPost.proj.Model.Package;

public class Caretaker {
    private List<MementoClass> mementoList = new ArrayList<MementoClass>();

    public void add(MementoClass memento) {
        mementoList.add(memento);
    }

    public void undo(Package pack) {
        if (mementoList.isEmpty()) {
            return;
        }
        MementoClass memento = mementoList.get(mementoList.size() - 1);
        mementoList.remove(mementoList.size() - 1);
        pack.restore(memento);
    }
}
