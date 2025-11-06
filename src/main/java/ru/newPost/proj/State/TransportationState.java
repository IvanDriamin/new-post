package ru.newPost.proj.State;

public class TransportationState implements StateInterface {
    @Override
    public void delivered(Context context) {
        System.out.println("null");
    }

    @Override
    public void returned(Context context) {
        System.out.println("null");
    }

    @Override
    public void transportation(Context context) {
        System.out.println("в пути");
    }

    @Override
    public void lost(Context context) {
        System.out.println("null");
    }
}
