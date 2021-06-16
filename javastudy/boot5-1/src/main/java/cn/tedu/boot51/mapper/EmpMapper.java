package cn.tedu.boot51.mapper;

import cn.tedu.boot51.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Insert("insert into t_emp values(null,#{name},#{sal},#{job})")
    void insert(Emp emp);
    @Delete("delete from t_emp where id=#{id}")
    void deleteById(int id);
    @Select("select id,name,sal,job from t_emp")
    List<Emp> selectAll();
    @Update("update t_emp set name=#{name},sal=#{sal},job=#{job} where id=#{id}")
    void update(Emp emp);
    @Select("select id,name,sal,job from t_emp where id=#{id}")
    Emp selectById(int id);
}
