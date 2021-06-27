package cn.tedu.cppfoto.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Words {
    private Integer id;
    private String contents;
    private Integer articleId;
    private Date createDate;
    private Integer userId;
}
