package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.beans.Info;
import cn.tedu.cppfoto.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article values(null,#{title},#{content},#{createDate},#{likeCount},#{collectionNum},#{categoryId},#{imagesNum},#{userId},#{source},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    int insert(Article article);

    @Select("SELECT a.*,i.imgurl from article a JOIN images i on a.id=i.articleId  WHERE a.userId=#{id} GROUP BY a.id")
    List<ArticleVo> selectById(int id);

    @Delete("delete from article where id=#{id}")
    int deleteById(int id);

    @Select("select * from article")
    List<Article> selctAll();

    List<InfoVo> selctInfoAll(Info info);

    @Select("select * from article where id=#{id}")
    Article select(int id);

    @Update("update article set likeCount=likeCount+1  where id=#{id}")
    int heart(int id);

    @Update("update article set collectionNum=collectionNum+1 where id=#{id}")
    int favorite(int id);
}
