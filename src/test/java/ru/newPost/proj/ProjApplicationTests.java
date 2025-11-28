package ru.newPost.proj;

import jakarta.persistence.GenerationType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.newPost.proj.ChainOfResponsibility.ConcreteHandler;
import ru.newPost.proj.Controller.PackageController;
import ru.newPost.proj.Memento.Caretaker;
import ru.newPost.proj.Memento.MementoClass;
import ru.newPost.proj.Service.PackageService;
import ru.newPost.proj.Model.Package;
import ru.newPost.proj.State.DeliveredState;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static ru.newPost.proj.Model.package_type.LETTER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ru.newPost.proj.Model.size.SMALL;

@SpringBootTest
class ProjApplicationTests {

    private PackageService PackageService;

    public PackageController controller;

    public Package obj = new Package();

    private Caretaker car;

    public ConcreteHandler ch;

    private DeliveredState ds;

    @Autowired
    public void PackageController (PackageService PackageService) {
        this.PackageService = PackageService;
    }

	//@Test
	//void contextLoads() {
	//}

    @Test
    void DeletePackage_ReturnsNoContent() {
        // Arrange
        Long id = 1L;
        doNothing().when(PackageService).deletePackage(id);

        // Act
        ResponseEntity<Void> response = controller.DeletePackage(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(PackageService, times(1)).deletePackage(id);
    }

    @Test
    void Save_ReturnsMementoWithCurrentState() {
        // Arrange
        MementoClass mementoClass = new MementoClass(1);

        // Act
        //MementoClass result = mementoClass.save();
        MementoClass result = obj.save();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getSavedState());
    }

    @Test
    void Restore_SetsCurrentStateFromMemento() {
        // Arrange
        MementoClass memento = new MementoClass(2);
        Package pack = new Package();

        // Act
        pack.restore(memento);

        // Assert
        // Проверьте, что current_point_id изменился на значение из memento
        // Например, если в классе Package есть геттер для current_point_id:
        // assertEquals(2, pack.getCurrentPointId());
    }

    @Test
    void Add_AddsMementoToList() {
        // Arrange
        MementoClass memento = new MementoClass(1);
        Package pack = new Package();

        // Act
        //pack.add(memento);
        car.add(memento);


        // Assert
        // Проверьте, что memento добавлен в список
        // Например, если в классе Package есть метод для получения списка:
        // assertTrue(pack.getMementoList().contains(memento));
    }

    @Test
    void Undo_RestoresPreviousState_WhenListIsNotEmpty() {
        // Arrange
        MementoClass memento = new MementoClass(1);
        Package pack = new Package();
        //pack.add(memento);
        car.add(memento);

        // Act
        //pack.undo(pack);
        car.undo(pack);

        // Assert
        // Проверьте, что список стал пустым и состояние восстановлено
        // assertTrue(pack.getMementoList().isEmpty());
        // assertEquals(1, pack.getCurrentPointId());
    }

    @Test
    void Undo_DoesNothing_WhenListIsEmpty() {
        // Arrange
        Package pack = new Package();

        // Act
        //pack.undo(pack);
        car.undo(pack);


        // Assert
        // Проверьте, что ничего не произошло
        // assertTrue(pack.getMementoList().isEmpty());
    }

    @Test
    void Process_PrintsCorrectMessage_WhenStartEqualsCurrent() {
        // Arrange
        Package pack = new Package();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        //pack.process(1, 1, 2, "2025-11-15");
        ch.process(1, 1, 2, "2025-11-15");

        // Assert
        assertEquals("Посылка в пути" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void Process_PrintsNotSentMessage_WhenStartNotEqualsCurrent() {
        // Arrange
        Package pack = new Package();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        //pack.process(1, 2, 2, "2025-11-15");
        ch.process(1, 2, 2, "2025-11-15");


        // Assert
        assertEquals("Ещё не отправлено" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void Delivered_PrintsCorrectMessage() {
        // Arrange
        Package pack = new Package();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        //pack.delivered(null);
        ds.delivered(null);

        // Assert
        assertEquals("Посылка доставлена" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void Returned_PrintsCorrectMessage() {
        // Arrange
        Package pack = new Package();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        //pack.delivered(null);
        ds.delivered(null);

        // Assert
        assertEquals("Посылка возвращена" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void Lost_PrintsCorrectMessage() {
        // Arrange
        Package pack = new Package();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        //pack.delivered(null);
        ds.delivered(null);

        // Assert
        assertEquals("Посылка потеряна" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void Transportation_PrintsCorrectMessage() {
        // Arrange
        Package pack = new Package();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        //pack.delivered(null);
        ds.delivered(null);

        // Assert
        assertEquals("в пути" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }
}
