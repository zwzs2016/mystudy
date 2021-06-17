package cn.tedu.vrd03.mapper;

import cn.tedu.vrd03.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {

    @Select("select id,url from banner")
    List<Banner> selectAll();
}
