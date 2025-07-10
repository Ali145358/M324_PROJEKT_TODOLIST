package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1") // Hier wird die API-Version für alle Endpunkte in dieser Klasse festgelegt
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @CrossOrigin
    @GetMapping("/")
    public List<Task> getTasks() {

        System.out.println("API v1 EP '/' returns task-list of size " + tasks.size() + ".");
        if (tasks.size() > 0) {
            int i = 1;
            for (Task task : tasks) {
                System.out.println("-task " + (i++) + ":" + task.getTaskdescription());
            }
        }
        return tasks; // actual task list (internally converted to a JSON stream)
    }

    @CrossOrigin
    @PostMapping("/tasks")
    public String addTask(@RequestBody String taskdescription) {
        System.out.println("API v1 EP '/tasks': '" + taskdescription + "'");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Task task;
            task = mapper.readValue(taskdescription, Task.class);
            for (Task t : tasks) {
                if (t.getTaskdescription().equals(task.getTaskdescription())) {
                    System.out.println(">>>task: '" + task.getTaskdescription() + "' already exists!");
                    return "redirect:/api/v1/"; // duplicates will be ignored
                }
            }
            System.out.println("...adding task: '" + task.getTaskdescription() + "'");
            tasks.add(task);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "redirect:/api/v1/";
    }

    @CrossOrigin
    @PostMapping("/delete")
    public String delTask(@RequestBody String taskdescription) {
        System.out.println("API v1 EP '/delete': '" + taskdescription + "'");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Task task;
            task = mapper.readValue(taskdescription, Task.class);
            Iterator<Task> it = tasks.iterator();
            while (it.hasNext()) {
                Task t = it.next();
                if (t.getTaskdescription().equals(task.getTaskdescription())) {
                    System.out.println("...deleting task: '" + task.getTaskdescription() + "'");
                    it.remove();
                    return "redirect:/api/v1/";
                }
            }
            System.out.println(">>>task: '" + task.getTaskdescription() + "' not found!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "redirect:/api/v1/";
    }
}
