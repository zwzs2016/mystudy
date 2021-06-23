package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article values(null,#{title},#{content},#{createDate},#{likeCount},#{collectionNum},#{categoryId},#{imagesNum},#{userId},#{source},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    void insert(Article article);

    @Select("SELECT a.*,i.imgurl from article a JOIN images i on a.id=i.articleId  WHERE a.userId=#{id} GROUP BY a.id")
    List<ArticleVo> selectById(int Id);

    @Delete("delete from article where id=#{id}")
    void deleteById(int id);

    @Select("select * from article")
    List<Article> selctAll();

    List<InfoVo> selctInfoAll(Integer categoryId);
}
