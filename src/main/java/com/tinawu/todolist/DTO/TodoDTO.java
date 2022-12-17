package com.tinawu.todolist.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TodoDTO {

    @Schema(description = "Todo's ID")
    private Integer id;
    @Schema(description = "Todo's titile")
    private String title;
    @Schema(description = "Todo's isDone?")
    private boolean done;
}
