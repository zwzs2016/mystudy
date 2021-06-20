package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article values(null,#{title},#{content},#{createDate},#{likeCount},#{categoryId},#{imgesId},#{userId},#{source},#{status})")
    void insert(Article article);
}
