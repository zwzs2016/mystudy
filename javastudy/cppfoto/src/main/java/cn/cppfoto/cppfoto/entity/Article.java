package cn.cppfoto.cppfoto.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Date createDate;
    private Integer likeCount;
    private Integer wordsId;
    private Integer imgesId;
    private Integer categoryId;
    private Integer userId;
}
