package ru.newPost.proj.ChainOfResponsibility;

public class ConcreteHandler extends Handler {
    @Override
    protected void process(int start_point_id, int current_point_id, int destination_point_id, String sended_at) {
        if (start_point_id != current_point_id) {
            System.out.println("Ещё не отправлено");
        } else {
            System.out.println("Посылка в пути");
        }
    }
}
