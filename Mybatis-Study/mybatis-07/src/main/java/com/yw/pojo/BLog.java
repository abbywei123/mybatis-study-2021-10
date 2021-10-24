package com.yw.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class BLog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
