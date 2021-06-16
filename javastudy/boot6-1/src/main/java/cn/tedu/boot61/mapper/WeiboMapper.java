package cn.tedu.boot61.mapper;

import cn.tedu.boot61.entity.Weibo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values(null,#{content},#{author},#{url},#{created},#{userid})")
    void insert(Weibo weibo);

    @Select("select * from weibo order by created desc")
    List<Weibo> selectAll();

    @Select("select * from weibo where userid=#{userid} order by created desc")
    List<Weibo> selectByUserId(Integer userid);

    @Delete("delete from weibo where id=#{id}")
    void deleteById(int id);

    @Select("select url from weibo where id=#{id}")
    String selectUrlById(int id);
}
