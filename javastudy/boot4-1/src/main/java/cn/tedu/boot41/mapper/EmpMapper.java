package cn.tedu.boot41.mapper;

import cn.tedu.boot41.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //告诉mybits框架此接口负责映射操作
public interface EmpMapper {
    //#{}语法先找变量名，去对象里面找属性名
    @Insert("insert into t_emp values(null,#{name},#{sal},#{job})")
    void insert(Emp emp);

    @Delete("delete from t_emp where id=#{id}")
    void deleteById(int id);
    @Select("select id,name,sal,job from t_emp")
    List<Emp> selectAll();
    @Update("update t_emp set name=#{name},sal=#{sal},job=#{job} where id=#{id}")
    void update(Emp emp);
}
