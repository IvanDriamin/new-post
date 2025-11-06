package ru.newPost.proj.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.newPost.proj.Memento.MementoClass;

@Entity
@Table(name = "package")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "package_type")
    private package_type package_type;

    @Column(name = "weight")
    private float weight;

    @Column(name = "size")
    private size size;

    @Column(name = "cost")
    private float cost;

    @Column(name = "sender_id")
    private int sender_id;

    @Column(name = "recipient_id")
    private int recipient_id;

    @Column(name = "start_point_id")
    private int start_point_id;

    @Column(name = "current_point_id")
    private int current_point_id;

    @Column(name = "destination_point_id")
    private int destination_point_id;

    @Column(name = "sended_at")
    private String sended_at;

    // Создает снимок состояния
    public MementoClass save() {
        return new MementoClass(this.current_point_id);
    }

    // Восстанавливает состояние из снимка
    public void restore(MementoClass memento) {
        this.current_point_id = memento.getSavedState();
        System.out.println("Текущий пункт: " + current_point_id);
    }


}
