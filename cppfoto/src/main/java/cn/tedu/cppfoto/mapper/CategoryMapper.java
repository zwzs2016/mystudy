package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> select(String directory);
}
