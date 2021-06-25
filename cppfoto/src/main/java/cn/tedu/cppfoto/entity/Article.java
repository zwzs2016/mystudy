package cn.tedu.cppfoto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;
    private int likeCount;
    private int collectionNum;
    private Integer categoryId;
    private Integer imagesNum;
    private Integer userId;
    private Integer source;
    private String status;
}
