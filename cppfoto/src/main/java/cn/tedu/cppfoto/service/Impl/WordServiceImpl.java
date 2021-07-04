package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.mapper.WordsMapper;
import cn.tedu.cppfoto.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;

public class WordServiceImpl implements WordsService {
    @Autowired
    WordsMapper wordsMapper;

    @Override
    public void deleteById(int id) {
        wordsMapper.deleteById(id);
    }
}
