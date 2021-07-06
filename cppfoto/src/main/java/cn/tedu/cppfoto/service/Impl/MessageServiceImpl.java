package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.MessageMapper;
import cn.tedu.cppfoto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> select(int id) {
        return messageMapper.select(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        messageMapper.deleteById(id);
    }
}
