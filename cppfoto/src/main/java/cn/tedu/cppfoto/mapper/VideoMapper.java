package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper {
    List<Video> select(Integer categoryId,Integer id);
}
