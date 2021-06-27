package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select m.id,m.content,u.username from message m join user u on m.fromuserId=u.id where m.userId=#{id}")
    List<Message> select(int id);

    @Delete("delete from message where id=#{id}")
    void deleteById(int id);

    @Insert("insert into message values(null,#{content},#{fromuserId},#{userId})")
    void insert(Message message);
}
