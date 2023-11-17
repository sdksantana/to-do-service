package com.github.todoservice;
import com.github.todoservice.model.TaskModel;
import com.github.todoservice.services.TaskServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TaskServicesTest {

    private TaskServices taskServices;

    @BeforeEach
    public void setUp() {
        taskServices = new TaskServices();
    }

    @Test
    public void addTaskTest() {
        TaskServices services = new TaskServices();

        var model = TaskModel.builder()
                .id("1")
                .description("Sei lá")
                .dueDate("2023/05/01")
                .completed(true)
                .build();

        ResponseEntity<String> response = taskServices.addTask(model);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tarefa adicionada com sucesso.", response.getBody());

    }
}