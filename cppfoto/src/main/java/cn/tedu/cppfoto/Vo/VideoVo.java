package cn.tedu.cppfoto.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class VideoVo {
    //order
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;
    private Integer paystatus;

    //video
    private Integer videoId;
    private String title;

    //images
    private String imgurl;

    //word 留言评论
    private Integer wordsId;
    private String contents;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date wordsCreateDate;
}
