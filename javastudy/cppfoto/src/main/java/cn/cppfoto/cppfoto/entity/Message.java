package cn.cppfoto.cppfoto.entity;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private String content;
    private Integer userId;
}
