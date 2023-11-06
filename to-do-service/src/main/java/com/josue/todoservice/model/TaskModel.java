package com.josue.todoservice.model;


import lombok.*;


@Data
public class TaskModel {
    private String id;
    private String description;
    private String expirationDate;
    private boolean isDone;

    public TaskModel(String id, String description, String expirationDate) {
        this.id = id;
        this.description = description;
        this.expirationDate = expirationDate;
        this.isDone = false;
    }
}
