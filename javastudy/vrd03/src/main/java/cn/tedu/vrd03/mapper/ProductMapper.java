package cn.tedu.vrd03.mapper;

import cn.tedu.vrd03.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{author},#{url},0,0,#{created},#{categoryId})")
    void insert(Product product);

    @Select("select id,title,url,viewCount,likeCount from product")
    List<Product> selectAll();
}
