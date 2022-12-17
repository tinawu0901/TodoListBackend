package com.tinawu.todolist;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tinawu.todolist.DTO.TodoDTO;
import com.tinawu.todolist.DTO.TodoResponseDTO;
import com.tinawu.todolist.Exception.MessageException;
import com.tinawu.todolist.Service.TodoListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 單元測試 使用3A標準
 * Arrange 初始化目標物件、相依物件、方法參數、預期結果
 * Act 呼叫目標物件的方法
 * Assert 驗證是否符合預期
 * @author yating wu
 * */
@SpringBootTest
@Transactional
class TodolistApplicationTests {
//	@Autowired
//	private TodoListService todoListService;
//
//	@Test
//	@Rollback
////單獨加上方法沒有用 還要在累上加Transactional
//	void addCreate(){
//		Integer excepted = 28;
//
//		TodoDTO todoDTO = new TodoDTO();
//		todoDTO.setTitle("大家好");
//		Integer todoID = todoListService.createTodo(todoDTO);
//		assertEquals(excepted, todoID);
//	}
//	@Test
//	void listTodo(){
//		List<TodoResponseDTO> list = todoListService.getList();
//		//list.forEach(n -> System.out.println(n));
//	}
//
//	@Test
//	void updateTitle() throws MessageException {
//		String excepted = "想睡覺";
//		TodoDTO todoDTO = new TodoDTO();
//		todoDTO.setId(28);
//		todoDTO.setTitle("想睡覺");
//		todoListService.updateTodoTitle(todoDTO);
//		assertEquals(excepted, todoDTO.getTitle());
//	}
//	@Test
//	void updateAllTodoDone() throws MessageException {
//		Boolean excepted = true;
//		Boolean done = true;
//		todoListService.updateAllTodoDone(done);
//		assertEquals(excepted,done);
//	}
//
//	@Test
//	void updateTodo(){
//		try {
//			todoListService.updateTodo(28);
//		} catch (MessageException e) {
//			throw new RuntimeException(e);
//		}
//
//
//	}
//		@Test
//		void  deleteId(){
//			try {
//				todoListService.deleteOne(28);
//			} catch (MessageException e) {
//				throw new RuntimeException(e);
//			}
//		}
}
