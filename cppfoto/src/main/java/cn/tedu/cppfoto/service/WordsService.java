package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.Words;

import java.util.List;

public interface WordsService {
    void deleteById(int id);

    void insert(Words words);

    List<WordsVo> select(Integer userId, Integer articleId);
}
