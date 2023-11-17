package com.github.todoservice;
import com.github.todoservice.model.TaskModel;
import com.github.todoservice.services.TaskServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TaskServicesTest {

    private TaskServices taskServices;

    @BeforeEach
    public void setUp() {
        taskServices = new TaskServices();
    }

    @Test
    public void testAddEditDeleteTask() {
        // adicionar
        TaskModel task1 = new TaskModel("Nova Tarefa");
        taskServices.addTask(task1);
        List<TaskModel> tasks = taskServices.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals(task1, tasks.get(0));

        // editar
        TaskModel task2 = new TaskModel("Tarefa Editada");
        taskServices.editTask(0, task2);
        tasks = taskServices.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals(task2, tasks.get(0));

        // deletar
        taskServices.deleteTask(0);
        assertTrue(taskServices.getAllTasks().isEmpty());
    }
}