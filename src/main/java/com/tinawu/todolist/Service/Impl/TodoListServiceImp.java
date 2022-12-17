package com.tinawu.todolist.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinawu.todolist.DTO.TodoDTO;
import com.tinawu.todolist.DTO.TodoResponseDTO;
import com.tinawu.todolist.Enumeration.MessageErrorCode;
import com.tinawu.todolist.Exception.MessageException;
import com.tinawu.todolist.Pojo.TodoListPo;
import com.tinawu.todolist.Repo.TodoListRepo;
import com.tinawu.todolist.Service.TodoListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Service
public class TodoListServiceImp implements TodoListService {
    @Autowired
    private TodoListRepo todoListRepo;

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public Integer createTodo(final TodoDTO todoDTO){
        //轉換
        final Timestamp systemCurrentTime = new Timestamp(System.currentTimeMillis());
        TodoListPo todoListPo = new TodoListPo();
        BeanUtils.copyProperties(todoDTO,todoListPo);
        todoListPo.setDone(false);
        todoListPo.setUpdateTime(systemCurrentTime);
        todoListPo.setCreateTime(systemCurrentTime);
        TodoListPo responsePo = todoListRepo.save(todoListPo);
        return  responsePo.getId();
    }

    //update
    @Override
    public void updateTodo(final Integer id)throws MessageException {
        TodoListPo todoListPo = findOneById(id);
        final Timestamp systemCurrentTime = new Timestamp(System.currentTimeMillis());
        todoListPo.setDone(!todoListPo.isDone());
        todoListPo.setUpdateTime(systemCurrentTime);
        todoListRepo.save(todoListPo);
        System.out.println("更新成功");
    }

    @Override
    public void updateTodoTitle(TodoDTO todoDTO) throws MessageException {
        TodoListPo todoListPo = this.findOneById(todoDTO.getId());
        final Timestamp systemCurrentTime = new Timestamp(System.currentTimeMillis());
        todoListPo.setTitle(todoDTO.getTitle());
        todoListPo.setUpdateTime(systemCurrentTime);
        todoListRepo.save(todoListPo);
    }

    @Override
    public void updateAllTodoDone(Boolean done) throws MessageException {
        List<TodoListPo> list = todoListRepo.findAll();
        list.forEach(todo -> todo.setDone(done) );
        todoListRepo.saveAll(list);
    }

    @Override
    public List<TodoResponseDTO> getList(){
        List<TodoListPo> TodoListPoAll = todoListRepo.findAll();
        List<TodoResponseDTO> todoResponseDTOS = new ArrayList<>();
        for(TodoListPo todoListPo : TodoListPoAll){
            TodoResponseDTO todoResponseDTO = new TodoResponseDTO();
            //轉換
            BeanUtils.copyProperties(todoListPo, todoResponseDTO);
            todoResponseDTOS.add(todoResponseDTO);
        }
        todoResponseDTOS.sort(Comparator.comparing(TodoResponseDTO:: getId));
        return todoResponseDTOS;
    }
    //delete
    @Override
    public void deleteOne(final  Integer id) throws MessageException {
        TodoListPo oneById = findOneById(id);
        todoListRepo.delete(oneById);
    }

    //findOne
    @Override
    public TodoListPo findOneById(final Integer id)throws MessageException {
        TodoListPo todoListPo = new TodoListPo();
       final Optional<TodoListPo> todo = todoListRepo.findById(id);
       //TodoList不存在請確認 在這裡寫就不用 寫在這裡就不用 在其他方法確認是否存在
        if(!todo.isPresent()){
            throw new MessageException(MessageErrorCode.TODO1.getErrorCode(), MessageErrorCode.TODO1.getErroMessage());
        }
        todoListPo = todo.get();//回傳 跟直接回傳差別
        return todoListPo;
    }





}
