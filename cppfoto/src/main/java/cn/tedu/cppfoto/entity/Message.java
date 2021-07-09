package cn.tedu.cppfoto.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Message {
    private Integer id;
    private String content;
    private Integer fromuserId;
    private Integer userId;
    private String username;
}
