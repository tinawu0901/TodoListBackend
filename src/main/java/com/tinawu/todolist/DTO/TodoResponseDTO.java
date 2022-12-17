package com.tinawu.todolist.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TodoResponseDTO {
    @Schema(description = "Todo's ID")
    private Integer id;
    @Schema(description = "Todo's titile")
    private String title;
    @Schema(description = "Todo's isDone?")
    private boolean done;
    @Schema(description = "Todo's last updateTime")
    private Timestamp updateTime;
    @Schema(description = "Todo's create updateTime")
    private Timestamp createTime;
}
