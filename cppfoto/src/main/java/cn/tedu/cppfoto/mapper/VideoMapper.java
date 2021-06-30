package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper {
    @Select("select id,title,imgurl from video  where categoryId=#{id}")
    List<Video> select(int id);
}
