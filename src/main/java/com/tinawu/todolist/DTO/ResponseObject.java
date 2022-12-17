package com.tinawu.todolist.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ResponseObject {
    @Schema(description = "Response Code",example = "TODO0")
    private String code;
    @Schema(description = "Response message" ,example = "OK")
    private String message;
    @Schema(description = "return  sucess" ,type = "Boolean",example = "true")
    private Boolean sucess;
    @JsonIgnore
    private Timestamp timestamp;

    private Object data;
    public ResponseObject(Timestamp timestamp,Boolean status,String code,String message,Object data){
        this.timestamp = timestamp;
        this.sucess = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
