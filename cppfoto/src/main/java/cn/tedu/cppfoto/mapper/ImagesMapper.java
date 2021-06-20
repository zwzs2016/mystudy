package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Images;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImagesMapper {
    @Select("select id,imgurl,categoryId from images i where id = (select imagesId from user where username=#{username})")
    Images selectById(String username);

    @Insert("insert into images values(null,#{imgUrl},null)")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    int insert(Images images);
}
