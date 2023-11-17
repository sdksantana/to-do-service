package com.github.todoservice.services;
import com.github.todoservice.model.TaskModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServices {
    private final List<TaskModel> tasks = new ArrayList<>();

    public List<TaskModel> getAllTasks() {
        return tasks;
    }

    public void addTask(TaskModel task) {
        tasks.add(task);
    }

    public void editTask(int taskId, TaskModel task) {
        tasks.set(taskId, task);
    }

    public void deleteTask(int taskId) {
        tasks.remove(taskId);
    }
}
