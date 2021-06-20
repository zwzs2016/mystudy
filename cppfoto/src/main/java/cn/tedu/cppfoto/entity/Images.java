package cn.tedu.cppfoto.entity;

import lombok.Data;

@Data
public class Images {
    private Integer id;
    private String imgUrl;
    private Integer categoryId;//分类id
}
