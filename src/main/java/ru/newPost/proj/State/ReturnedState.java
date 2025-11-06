package ru.newPost.proj.State;

public class ReturnedState implements StateInterface {
    @Override
    public void delivered(Context context) {
        System.out.println("null");
    }

    @Override
    public void returned(Context context) {
        System.out.println("посылка возвращена");
    }

    @Override
    public void transportation(Context context) {
        System.out.println("null");
    }

    @Override
    public void lost(Context context) {
        System.out.println("null");
    }
}
