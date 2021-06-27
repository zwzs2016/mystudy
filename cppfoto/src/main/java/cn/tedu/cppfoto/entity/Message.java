package cn.tedu.cppfoto.entity;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private String content;
    private Integer fromuserId;
    private Integer userId;
    private String username;
}
