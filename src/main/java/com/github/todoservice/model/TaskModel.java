package com.github.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TaskModel {

    private String id;

    private String description;

    private String dueDate;

    private Boolean completed;

    public TaskModel(String novaTarefa) {
    }
}
