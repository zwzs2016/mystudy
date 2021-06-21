package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper{
    @Select("select * from user where username=#{username}")
    User checkUserName(String username);

    @Insert("insert into user values(null,#{username},#{password},#{mail},#{name},#{sex},#{birthday},#{fixedPhone},#{unit},#{region},#{address},#{postcode},#{cameraName},#{cameraModel},#{phoneNum},null)")
    void insert(User user);

    void update(User user);

}
