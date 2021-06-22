package cn.tedu.cppfoto.Vo;

import cn.tedu.cppfoto.entity.Article;
import lombok.Data;

@Data
public class InfoVo {
    private Integer id;
    private String title;
    private Integer likeCount;
    private Integer collectionNum;
    private Integer imagesNum;
    private String articleImgUrl;
    private String userImgUrl;
}
