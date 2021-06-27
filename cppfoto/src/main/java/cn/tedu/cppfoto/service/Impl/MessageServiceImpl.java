package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.MessageMapper;
import cn.tedu.cppfoto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Value("${user.adminId}")
    private int adminId;
    @Autowired
    MessageMapper messageMapper;


    @Override
    public void register(User user) {
        Message message=new Message();
        message.setContent("您好，欢迎注册!");
        message.setFromuserId(adminId);
        message.setId(user.getId());
        messageMapper.insert(message);
    }
}
