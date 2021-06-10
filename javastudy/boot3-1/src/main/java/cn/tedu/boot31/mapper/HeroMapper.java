package cn.tedu.boot31.mapper;

import cn.tedu.boot31.entity.Emp;
import cn.tedu.boot31.entity.Hero;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //告诉mybits框架此接口负责映射操作
public interface HeroMapper {
    //#{}语法先找变量名，去对象里面找属性名
    @Insert("insert into hero values(null,#{name},#{type},#{money})")
    void insert(Hero hero);

    @Delete("delete from hero where id=#{id}")
    void deleteById(int id);
    @Select("select id,name,type,money from hero")
    List<Hero> selectAll();
    @Update("update hero set name=#{name},type=#{type},money=#{money} where id=#{id}")
    void update(Hero hero);
}
