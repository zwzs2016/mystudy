package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article values(null,#{title},#{content},#{createDate},#{likeCount},#{categoryId},#{imgesId},#{userId},#{source},#{status})")
    void insert(Article article);

    @Select("SELECT a.*,i.imgurl from article a JOIN images i on a.imgesId=i.id WHERE a.userId=(SELECT id from user WHERE username=#{username});")
    List<ArticleVo> selectByUserName(String username);

    @Delete("delete from article where id=#{id}")
    void deleteById(int id);
}
