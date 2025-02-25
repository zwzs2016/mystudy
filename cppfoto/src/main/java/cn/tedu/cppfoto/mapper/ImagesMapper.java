package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Images;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImagesMapper {

    @Insert("insert into images values(null,#{imgUrl},#{articleId},#{videoId})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    int insert(Images images);

    @Select("select id,imgurl,articleId from images where id=(select imagesId from user where id=#{id})")
    Images selectById(int id);

    @Select("select * from images where id=(select imagesId from user where id=#{id})")
    Images selectByUserId(int id);

    @Select("select id,imgurl,articleId from images where articleId=#{id}")
    List<Images> selectByArticleId(int id);
}
