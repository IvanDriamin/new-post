package ru.newPost.proj.ChainOfResponsibility;

public class TheMostConcreteHandler extends Handler {
    @Override
    protected void process(int start_point_id, int current_point_id, int destination_point_id, String sended_at) {
        if (current_point_id == destination_point_id) {
            System.out.println("Доставлено в: " + sended_at);
        } else {
            System.out.println("Посылка в пути");
        }
    }
}
