package com.tinawu.todolist.Advice;

import com.tinawu.todolist.DTO.ResponseObject;
import com.tinawu.todolist.Enumeration.MessageErrorCode;
import com.tinawu.todolist.Exception.MessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

/*
*
*
* 攔截錯誤訊息
* */
@RestControllerAdvice
public class ApiExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value = MessageException.class)
    public ResponseEntity<ResponseObject>messageExceptionHandler(final MessageException messageException){
        logger.info("Occur TodoListAPI MessageException,errCode:{},message:{}",messageException.getErrorCode(),messageException.getErrorMessage());
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final ResponseObject responseObject = new ResponseObject(timestamp,false,messageException.getErrorCode(),messageException.getErrorMessage(),messageException.getData());
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseObject> apiExceptionHandler(final Exception exception){
        logger.info("Occur internal Exception,message:{}",exception.getMessage(),exception);
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final ResponseObject responseObject = new ResponseObject(timestamp,false, MessageErrorCode.TOD99.getErrorCode(), MessageErrorCode.TOD99.getErroMessage(),null);
        return new ResponseEntity<>(responseObject,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
