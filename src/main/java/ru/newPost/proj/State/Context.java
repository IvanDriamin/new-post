package ru.newPost.proj.State;

public class Context {
    private StateInterface currentState;

    public void setState(StateInterface state) {
        this.currentState = state;
    }

    public void delivered() {
        currentState.delivered(this);
    }

    public void returned() {
        currentState.returned(this);
    }

    public void transportation() {
        currentState.transportation(this);
    }

    public void lost() {
        currentState.lost(this);
    }
}
