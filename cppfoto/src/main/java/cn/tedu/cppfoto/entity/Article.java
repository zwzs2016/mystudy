package cn.tedu.cppfoto.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Date createDate;
    private Integer likeCount;
    private Integer categoryId;
    private Integer imgesNum;
    private Integer userId;
    private Integer source;
    private String status;
}
