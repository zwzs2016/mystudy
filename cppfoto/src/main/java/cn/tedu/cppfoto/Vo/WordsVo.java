package cn.tedu.cppfoto.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WordsVo {
    private Integer id;
    private String contents;
    private String title;
    private String username;
    private Integer articleId;
    private String imgUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createDate;
    private int status;
}
