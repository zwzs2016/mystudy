package cn.tedu.cppfoto.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Words {
    private Integer id;
    private Date createDate;
    private Integer articleId;
    private Integer userId;
}
