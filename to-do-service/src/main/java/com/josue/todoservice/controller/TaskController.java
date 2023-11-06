package com.josue.todoservice.controller;

import com.josue.todoservice.model.TaskModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    List<TaskModel> taskList = new ArrayList<>();

    @GetMapping("/tasks")
    public String displayTask() {
        if (taskList.isEmpty()) {
            return "Nenhuma tarefa no momento!";
        } else {
            String id = "", description = "", expirationDate = "";
            boolean isDone = false;
            for (TaskModel task: taskList
            ) {
                id = task.getId();
                description = task.getDescription();
                expirationDate = task.getExpirationDate();
                isDone = task.isDone();
            }

            return "ID: " + id +
                    "Descrição: " + description +
                    "Data de vencimento: " + expirationDate +
                    "Está concluída? " + isDone;
        }
    }   
}
