package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Collection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollectionMapper {
    @Insert("insert into collection values(null,#{articleId},#{userId})")
    void insert(Collection collection);

    @Select("select id from collection where articleId=#{articleId} and userId=#{userId}")
    Integer isCollection(Collection collection);
}
