package cn.tedu.vrd03.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id;
    private String title;
    private String author;
    private String url;
    private String intro;
    private Integer viewCount;
    private Integer likeCount;
    private Date created;
    private Integer categoryId;

}
