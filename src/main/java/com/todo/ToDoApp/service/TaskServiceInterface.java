package com.todo.ToDoApp.service;

import com.todo.ToDoApp.dao.Task;

import java.util.Map;

public interface TaskServiceInterface {

    public Map<String,Object> getAllTasks();

    public Task insertTask(String Taskname);

    void deleteTask(int id);

    public Boolean updateStatus(int id);
}
