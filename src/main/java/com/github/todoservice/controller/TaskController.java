package com.github.todoservice.controller;
import com.github.todoservice.model.TaskModel;
import com.github.todoservice.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    private final List<TaskModel> tasks = new ArrayList<>();

    @GetMapping
    public List<TaskModel> getAllTasks() {
        return taskServices.getAllTasks();
    }

    @PostMapping("/add")

    public ResponseEntity<String> addTask(@RequestBody TaskModel task) {
        try {
            taskServices.addTask(task);
            return new ResponseEntity<>("Tarefa adicionada com sucesso.", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{taskId}")
    public ResponseEntity<String> editTask(@PathVariable int taskId, @RequestBody TaskModel task) {
        try {
            taskServices.editTask(taskId, task);
            return new ResponseEntity<>("Tarefa editada com sucesso.", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao editar a tarefa.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        try {
            taskServices.deleteTask(taskId);
            return new ResponseEntity<>("Tarefa removida com sucesso.", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Erro ao remover a tarefa.", HttpStatus.BAD_REQUEST);
        }
    }
}
