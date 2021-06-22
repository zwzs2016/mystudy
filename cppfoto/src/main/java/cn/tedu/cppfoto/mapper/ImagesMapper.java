package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Images;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImagesMapper {

    @Insert("insert into images values(null,#{imgUrl},null)")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    int insert(Images images);

    @Select("select id,imgurl,articleId from images where id=#{id}")
    Images selectById(int id);

    @Select("select * from images where id=(select imagesId from user where id=#{id})")
    Images selectByUserId(int id);

    @Select("select id,imgurl,articleId from images where articleId=#{id} limit 1")
    Images selectByArticleId(int id);
}
