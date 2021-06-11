package cn.tedu.boot41.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //通过用户名查询到对应的密码
    @Select("select password from user where username=#{username}")
    String login(String username);
}
