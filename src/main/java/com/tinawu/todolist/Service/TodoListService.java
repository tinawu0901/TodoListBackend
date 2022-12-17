package com.tinawu.todolist.Service;

import com.tinawu.todolist.DTO.TodoDTO;
import com.tinawu.todolist.DTO.TodoResponseDTO;
import com.tinawu.todolist.Exception.MessageException;
import com.tinawu.todolist.Pojo.TodoListPo;

import java.util.List;


public interface TodoListService {
    Integer createTodo(final TodoDTO todoDTO) ;

    void updateTodo(final Integer id) throws MessageException;

    void updateTodoTitle(TodoDTO todoDTO) throws MessageException;

    void updateAllTodoDone(Boolean done) throws MessageException;

    List<TodoResponseDTO> getList();

    void deleteOne(final  Integer id)  throws MessageException;

    TodoListPo findOneById(final Integer id)  throws MessageException;
}
