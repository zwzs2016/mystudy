package cn.tedu.cppfoto.mapper;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.Words;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordsMapper {
    @Insert("insert into words values(null,#{contents},#{articleId},#{createDate},#{userId})")
    void insert(Words words);

    @Select("SELECT w.id,w.contents,a.title,i.imgurl,w.createDate,w.`status` from words w JOIN article a  JOIN images i on w.articleId=a.id and a.id=i.articleId WHERE w.userId=#{id}")
    List<WordsVo> selectAll(int id);
}
