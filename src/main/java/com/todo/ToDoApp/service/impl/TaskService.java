package com.todo.ToDoApp.service.impl;

import com.todo.ToDoApp.dao.Task;
import com.todo.ToDoApp.dao.TaskStatus;
import com.todo.ToDoApp.repository.TaskRepository;
import com.todo.ToDoApp.service.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService implements TaskServiceInterface{

    @Autowired
    TaskRepository taskRepo;

    @Override
    public Map<String,Object> getAllTasks() {

        List<Task> taskData = taskRepo.findAll();
        Map allTasks = new HashMap<String, Object>();
        List<Task> completeTask = new ArrayList<>();
        List<Task> pendingTask = new ArrayList<>();
        if(taskData != null){
            for(Task task : taskData){
                if(task.getStatus() == TaskStatus.completed){
                    completeTask.add(task);
                }
                if(task.getStatus() == TaskStatus.pending){
                    pendingTask.add(task);
                }
            }
        }
        allTasks.put("all",taskData);
        allTasks.put("pending",pendingTask);
        allTasks.put("completed",completeTask);

        return allTasks;
    }

    @Override
    public Task insertTask(String Taskname) {
        Task newTask = new Task();

        newTask.setStatus(TaskStatus.pending);
        newTask.setCreatedat(new Date());
        newTask.setTaskname(Taskname);

        taskRepo.save(newTask);

        return newTask;
    }

    @Override
    public void deleteTask(int id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Boolean updateStatus(int taskId) {

        Task taskData = taskRepo.findById(taskId);
        taskData.setStatus(TaskStatus.completed);
        taskRepo.save(taskData);

        return true;
    }
}
