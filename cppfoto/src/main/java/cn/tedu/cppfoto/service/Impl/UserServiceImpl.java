package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Integral;
import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.IntegralMapper;
import cn.tedu.cppfoto.mapper.MessageMapper;
import cn.tedu.cppfoto.service.UserService;

import cn.tedu.cppfoto.utils.DateHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Value("${user.adminId}")
    private int adminId;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    IntegralMapper integralMapper;
    @Autowired
    DateHandle dateHandle;

    @Override
    public void integral(User user) {
        Integral integral;
        if(integralMapper.select(user.getId()).size()>0){
            integral = integralMapper.select(user.getId()).get(0);
            Date startDate=integral.getCreateDate();
            integral.setId(null);
            integral.setUserId(user.getId());
            integral.setCreateDate(new Date());
            integral.setExplain("每天登录");
            integral.setPay(10);
            if(!dateHandle.isToday(startDate)){
                integralMapper.insert(integral);
            }
        }else {
            integral=new Integral();
            integral.setUserId(user.getId());
            integral.setCreateDate(new Date());
            integral.setExplain("注册用户");
            integral.setPay(100);
            integralMapper.insert(integral);
        }
    }

    @Override
    public void register(User user) {
        Message message=new Message();
        message.setContent("您好，欢迎注册!");
        message.setFromuserId(adminId);
        message.setUserId(user.getId());
        messageMapper.insert(message);
    }

}
