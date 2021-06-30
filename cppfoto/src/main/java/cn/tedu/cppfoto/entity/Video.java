package cn.tedu.cppfoto.entity;

import lombok.Data;

@Data
public class Video {
    private Integer id;
    private String title;
    private String imgurl;
    private Integer categoryId;
}
