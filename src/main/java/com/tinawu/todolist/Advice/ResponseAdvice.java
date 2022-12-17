package com.tinawu.todolist.Advice;

import com.tinawu.todolist.DTO.ResponseObject;
import com.tinawu.todolist.Enumeration.MessageErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.sql.Timestamp;

@RestControllerAdvice("com.tinawu.todolist")
public class ResponseAdvice implements ResponseBodyAdvice {
    private Logger logger = LoggerFactory.getLogger(ResponseAdvice.class);
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        final String methodName = returnType.getMethod().getName();
        System.out.println(methodName);
        return !"apiExceptionHandler".equals(methodName)&& !"messageExceptionHandler".equals(methodName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logger.info("Response OK 。 時間:"+timestamp);
        final ResponseObject responseObject = new ResponseObject(timestamp,true, MessageErrorCode.TODO0.getErrorCode(), HttpStatus.OK.name(),body);
        return responseObject;
    }
}
