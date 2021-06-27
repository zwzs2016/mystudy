package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.Vo.CollectionVo;
import cn.tedu.cppfoto.entity.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionMapper {
    @Insert("insert into collection values(null,#{articleId},#{userId})")
    void insert(Collection collection);

    @Select("select id from collection where articleId=#{articleId} and userId=#{userId}")
    Integer isCollection(Collection collection);

    @Delete("delete from collection where id=#{id}")
    void deleteById(int id);

    @Select("select c.id,a.title,i.imgurl,a.id as articleId from collection c JOIN article a JOIN images i on c.articleId=a.id and a.id=i.articleId where c.userId=#{userId}")
    List<CollectionVo> select(int userId);

}
