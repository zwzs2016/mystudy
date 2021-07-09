package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.Words;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordsMapper {
    @Insert("insert into words values(null,#{contents},#{articleId},#{createDate},#{userId},0,#{videoId})")
    void insert(Words words);

    List<WordsVo> select(Integer userId,Integer articleId);

    @Delete("delete from words where id=#{id}")
    void deleteById(int id);

    @Delete("delete from words where articleId=#{id}")
    int deleteByArticleId(int id);
}
