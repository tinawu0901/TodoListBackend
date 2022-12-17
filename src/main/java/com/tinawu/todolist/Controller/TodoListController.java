package com.tinawu.todolist.Controller;

import com.tinawu.todolist.DTO.TodoDTO;
import com.tinawu.todolist.DTO.TodoResponseDTO;
import com.tinawu.todolist.Exception.MessageException;
import com.tinawu.todolist.Service.TodoListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "代辦清單")
@RestController
@CrossOrigin
@RequestMapping("todoList")
public class TodoListController {
    private Logger logger = LoggerFactory.getLogger(TodoListController.class);
    @Autowired
    private TodoListService todoListService;

    /**
     * 查詢全部
     * */
    @Operation(summary = "查詢全部代辦事項",description = "查詢全部代辦事項")
    @GetMapping("getAllTodo")
    public List<TodoResponseDTO> getTodoList(){
        logger.info("查詢全部");
        List<TodoResponseDTO> list = todoListService.getList();
        return list;
    }

    /**
     * 新增Todo
     * @param todoResponseDTO
     * @return
     */
    @Operation(summary = "新增代辦事項",description = "新增一筆代辦事項")
    @PostMapping("createTodo")
    public Integer createTodo(@RequestBody final TodoDTO todoDTO){//要加@requestBody 否則部會自動映射
        System.out.println(todoDTO.getTitle());
        logger.info("新增Todo");
        //logger
        return  todoListService.createTodo(todoDTO);
    }
    /**
     * 變更為已完成
     * @param id
     * @throws MessageException
     */
    @Operation(summary = "變更代辦事項完成狀態",description = "變更代辦事項完成狀態")
    @PutMapping("updateTodo/{id}")
    public void updateTodo(@PathVariable final Integer id) throws MessageException {
        logger.info("Todo變更為已完成");
        //logger
         todoListService.updateTodo(id);
    }
    /**
     * 變更Todo title內容
     *@param todoResponseDTO
     * @throws MessageException
     */
    @Operation(summary = "變更代辦事項標題內容",description = "變更代辦事項標題內容")
    @PutMapping("updateTodoTitle")
    public void updateTodoTitile(@RequestBody TodoDTO todoDTO) throws MessageException {
        logger.info("Todo變更為title成功");
        //logger
        todoListService.updateTodoTitle(todoDTO);
    }
    /**
     * 全選或取消全選
     * @param done
     * @throws MessageException
     */
    @Operation(summary = "變更全部代辦事項完成狀態",description = "變更全部代辦事項完成狀態")
    @PutMapping("updateAllTodoDone")
    public void updateAllTodoDone(@RequestParam Boolean done) throws MessageException {
        logger.info("全選或取消全選Todo");
        //logger
        todoListService.updateAllTodoDone(done);
    }



    /**
     * 刪除
     * @param id
     * @throws MessageException
     */
    @Operation(summary = "刪除一筆代辦事項",description = "刪除一筆代辦事項")
    @DeleteMapping("deleteTodo/{id}")
    public void delete(@PathVariable final Integer id) throws MessageException{
        logger.info("取消Todo");
        todoListService.deleteOne(id);
    }

}
