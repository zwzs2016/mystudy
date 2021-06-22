package cn.tedu.vrd03.mapper;

import cn.tedu.vrd03.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{author},#{url},#{intro},0,0,#{created},#{categoryId})")
    void insert(Product product);

    @Select("select id,title,url,intro,viewCount,likeCount from product")
    List<Product> selectAll();

    @Select("select * from product order by likeCount desc limit 4")
    List<Product> likeList();

    @Select("select * from product order by viewCount desc limit 4")
    List<Product> viewList();

    @Select("select * from product where categoryId=#{id}")
    List<Product> findByCid(int id);

    @Select("select * from product where title like concat('%',#{wd},'%')")
    List<Product> findByWd(String wd);

    @Select("select * from product where id=#{id}")
    Product findByid(int id);

    @Update("update product set likeCount=likeCount+1 where id=#{id}")
    void likeById(int id);

    @Update("update product set viewCount=viewCount+1;")
    void viewById(int id);

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);
}
