package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Integral;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IntegralMapper {
    @Select("select id,createDate,pay,`explain` from integral where userId=#{id} order by createDate desc")
    List<Integral> select(int id);

    @Insert("insert into integral values(null,#{createDate},#{pay},#{explain},#{userId})")
    void insert(Integral integral);

    @Select("select sum(pay) from integral where userId=#{id}")
    int socreSum(int id);
}
