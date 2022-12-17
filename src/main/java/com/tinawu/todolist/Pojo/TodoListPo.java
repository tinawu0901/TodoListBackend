package com.tinawu.todolist.Pojo;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "todolist")
public class TodoListPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "done")
    private boolean done;
    @Column(name = "update_Time")
    private Timestamp updateTime;
    @Column(name = "create_Time")
    private Timestamp createTime;
}
