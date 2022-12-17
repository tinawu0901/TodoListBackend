package com.tinawu.todolist.Repo;

import com.tinawu.todolist.Pojo.TodoListPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepo extends JpaRepository<TodoListPo, Integer> {

}
