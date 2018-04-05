package com.todo.ToDoApp.repository;

import com.todo.ToDoApp.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

//    @Query(value="SELECT n FROM News n, NewsRole ns where ns.news=n.id and ns.roleId = ?1")
//    public List<Task> findNewsData(int roleId);

    public Task findById(int id);
}
