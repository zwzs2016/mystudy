package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.Words;
import cn.tedu.cppfoto.exception.ServiceException;
import cn.tedu.cppfoto.mapper.MessageMapper;
import cn.tedu.cppfoto.mapper.WordsMapper;
import cn.tedu.cppfoto.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class WordServiceImpl implements WordsService {
    @Autowired
    WordsMapper wordsMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public void deleteById(int id) {
        wordsMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void insert(Words words) {
        wordsMapper.insert(words);
        if(words.getReplyuserId()!=null){
            Message message=new Message();
            message.setContent(words.getContents())
                    .setFromuserId(words.getUserId())
                    .setUserId(words.getReplyuserId());
            int num = messageMapper.insert(message);
            if(num!=1){
                throw new ServiceException("服务器忙!");
            }
        }
    }

    @Override
    public List<WordsVo> select(Integer userId, Integer articleId) {
        return wordsMapper.select(userId,articleId);
    }
}
