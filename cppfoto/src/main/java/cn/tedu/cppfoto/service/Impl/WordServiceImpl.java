package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.Words;
import cn.tedu.cppfoto.mapper.WordsMapper;
import cn.tedu.cppfoto.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordServiceImpl implements WordsService {
    @Autowired
    WordsMapper wordsMapper;

    @Override
    public void deleteById(int id) {
        wordsMapper.deleteById(id);
    }

    @Override
    public void insert(Words words) {
        wordsMapper.insert(words);
    }

    @Override
    public List<WordsVo> select(Integer userId, Integer articleId) {
        return wordsMapper.select(userId,articleId);
    }
}
