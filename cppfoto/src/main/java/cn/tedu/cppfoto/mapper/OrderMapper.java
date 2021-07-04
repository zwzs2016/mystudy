package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into `order` values(null,#{paystatus},#{isCollection},#{wordsId},#{userId},#{videoId})")
    void insert(Order order);

    @Select("select * from `order` where userId=#{userId} and videoId=#{videoId}")
    Order selectByUserIdAndVideoId(int userId, int videoId);

    @Delete("delete from `order` where id=#{id}")
    int deleteById(int id);

    @Update("update `order` set isCollection=#{isCollection} where id=#{id}")
    void updateCollectionById(int id,int isCollection);

}
