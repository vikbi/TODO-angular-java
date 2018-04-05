package com.todo.ToDoApp.controller;

import com.todo.ToDoApp.service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(name = "/")
    public Map getTaskList(){
        return taskService.getAllTasks();
    }

    @PostMapping(name = "/")
    public Map addTask(@RequestParam(value = "taskname", required = true) String taskName){
        taskService.insertTask(taskName);
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public Map deleteRankRequest(@PathVariable(value = "id") int id)
    {
        taskService.deleteTask(id);
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Map updateTaskStatus(@PathVariable(value = "id") int id)
    {
        taskService.updateStatus(id);
        return taskService.getAllTasks();
    }
}
