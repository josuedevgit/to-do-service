package com.josue.todoservice.controller;

import com.josue.todoservice.model.TaskModel;
import org.springframework.web.bind.annotation.*;

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
                System.out.println("ID: " + id);
                System.out.println("Descrição: " + description);
                System.out.println("Data de vencimento: " + expirationDate);
                System.out.println("Está concluído? " + isDone);
                System.out.println("======================");
            }

            return "ID: " + id;
        }
    }

    @PostMapping("/tasks/add")
    public void addTask(@RequestBody String id, String description, String expirationDate) {
        TaskModel task = new TaskModel(id, description, expirationDate);
        taskList.add(task);
        System.out.println("Tarefa adicionada!");
    }

//    @PutMapping("/tasks/edit/{taskId}")
//    public void editTask(@PathVariable String taskId, @RequestBody TaskModel task) {
//        for (TaskModel taskItem : taskList) {
//            if(taskItem.getId().equals(taskId)) {
//                taskItemtask.getId();
//            }
//        }
//    }
}
