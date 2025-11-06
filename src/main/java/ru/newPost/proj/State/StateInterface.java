package ru.newPost.proj.State;

public interface StateInterface {
    void delivered(Context context);

    void returned(Context context);

    void transportation(Context context);

    void lost(Context context);
}
