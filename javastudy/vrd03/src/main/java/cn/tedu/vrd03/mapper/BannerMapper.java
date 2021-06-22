package cn.tedu.vrd03.mapper;

import cn.tedu.vrd03.entity.Banner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {

    @Select("select id,url from banner")
    List<Banner> selectAll();

    @Select("select url from banner where id=#{id}")
    String findUrlById(int id);

    @Delete("delete from banner where id=#{id}")
    void deleteById(int id);

    @Insert("insert into banner values(null,#{url})")
    void insert(Banner banner);
}
