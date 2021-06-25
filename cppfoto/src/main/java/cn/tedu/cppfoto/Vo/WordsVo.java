package cn.tedu.cppfoto.Vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WordsVo {
    private Integer id;
    private String contents;
    private String title;
    private String imgUrl;
    private LocalDateTime createDate;
    private int status;
}
