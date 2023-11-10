package com.josue.todoservice.controller;

import com.josue.todoservice.model.TaskModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    // problemas com relação à adicionar
    @PostMapping("/tasks/add")
    public void addTask(@RequestBody String id, String description, String expirationDate) {
        TaskModel task = createTask(id, description, expirationDate);
        taskList.add(task);
    }


    // metodo para instanciar TaskModel
    public TaskModel createTask(String id, String description, String expirationDate) {
        TaskModel task = new TaskModel(id, description, expirationDate);

        return task;
    }
}
