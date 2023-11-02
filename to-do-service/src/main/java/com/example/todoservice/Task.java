package com.example.todoservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String id;
    private String description;
    private String expirationDate;
    private boolean isDone;
}
