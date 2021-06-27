package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper{

    User check(User user);

    @Insert("insert into user values(null,#{username},#{password},#{mail},#{name},#{sex},#{birthday},#{fixedPhone},#{unit},#{region},#{address},#{postcode},#{cameraName},#{cameraModel},#{phoneNum},null)")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    void insert(User user);

    void update(User user);

    @Select("select * from user where id=#{id}")
    User selectById(int id);
}
