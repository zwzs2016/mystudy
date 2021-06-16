package cn.tedu.boot61.mapper;

import cn.tedu.boot61.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user values(null,#{username},#{password},#{nick})")
    void insert(User user);

    @Select("select id,username,password,nick from user where username=#{username}")
    User login(String username);

}
