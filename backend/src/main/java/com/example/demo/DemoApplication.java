package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a demo application that provides a RESTful API for a simple ToDo list
 * without persistence.
 * The endpoint "/" returns a list of tasks.
 * The endpoint "/tasks" adds a new unique task.
 * The endpoint "/delete" removes a task from the list.
 * The task description transferred from the (React) client is provided as a
 * request body in a JSON structure.
 * The data is converted to a task object using Jackson and added to the list of
 * tasks.
 * All endpoints are CORS-enabled for cross-origin requests.
 */
@RestController
@SpringBootApplication

public class DemoApplication {

    private List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // Allow all localhost origins for development
        config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


    @GetMapping("/api/v1/")
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


    @PostMapping("/api/v1/tasks")
    public List<Task> addTask(@RequestBody String taskdescription) {
        System.out.println("API v1 EP '/tasks': '" + taskdescription + "'");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Task task = mapper.readValue(taskdescription, Task.class);
            for (Task t : tasks) {
                if (t.getTaskdescription().equals(task.getTaskdescription())) {
                    System.out.println(">>>task: '" + task.getTaskdescription() + "' already exists!");
                    return tasks; // duplicates will be ignored
                }
            }
            System.out.println("...adding task: '" + task.getTaskdescription() + "'");
            tasks.add(task);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return tasks;
    }


    @PostMapping("/api/v1/delete")
    public List<Task> delTask(@RequestBody String taskdescription) {
        System.out.println("API v1 EP '/delete': '" + taskdescription + "'");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Task taskToDelete = mapper.readValue(taskdescription, Task.class);
            Iterator<Task> it = tasks.iterator();
            while (it.hasNext()) {
                Task currentTask = it.next();
                if (currentTask.getTaskdescription().equals(taskToDelete.getTaskdescription())) {
                    System.out.println("...deleting task: '" + taskToDelete.getTaskdescription() + "'");
                    it.remove();
                    return tasks;
                }
            }
            System.out.println(">>>task: '" + taskToDelete.getTaskdescription() + "' not found!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
