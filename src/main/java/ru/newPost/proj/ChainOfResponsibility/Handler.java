package ru.newPost.proj.ChainOfResponsibility;

abstract class Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(int start_point_id, int current_point_id, int destination_point_id, String sended_at) {
        process(start_point_id, current_point_id, destination_point_id, sended_at);
        if (nextHandler != null) {
            nextHandler.handle(start_point_id, current_point_id, destination_point_id, sended_at);
        }
    }

    protected abstract void process(int start_point_id, int current_point_id, int destination_point_id, String sended_at);
}
