package cn.cppfoto.cppfoto.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id from user where username=#{username}")
    Integer checkUserName(String username);
}
