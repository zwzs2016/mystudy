package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Integral;
import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.IntegralMapper;
import cn.tedu.cppfoto.mapper.MessageMapper;
import cn.tedu.cppfoto.mapper.UserMapper;
import cn.tedu.cppfoto.service.UserService;

import cn.tedu.cppfoto.utils.DateHandle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Value("${user.adminId}")
    private int adminId;
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserMapper uMapper;

    @Autowired
    IntegralMapper integralMapper;
    @Autowired
    DateHandle dateHandle;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;

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

    @Override
    public void setUser(User user) {
        try {
            stringRedisTemplate.opsForValue().set("USER_"+user.getId(),objectMapper.writeValueAsString(user),30, TimeUnit.MINUTES);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(User user) {
        User u=null;
        if(stringRedisTemplate.hasKey("USER_"+user.getId())) {
            try {
                u = objectMapper.readValue(stringRedisTemplate.opsForValue().get("USER_" + user.getId()), User.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return u;
        }
        return uMapper.check(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        uMapper.update(user);
        //更新Redis
        if(stringRedisTemplate.hasKey("USER_"+user.getId())){
            stringRedisTemplate.delete("USER_"+user.getId());
        }
        try {
            stringRedisTemplate.opsForValue().set("USER_"+user.getId(),objectMapper.writeValueAsString(uMapper.check(user)),30, TimeUnit.MINUTES);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User check(User user) {
        return uMapper.check(user);
    }

    @Override
    public void insert(User user) {
        uMapper.insert(user);
    }

    @Override
    public User selectById(int id) {
        return uMapper.selectById(id);
    }

}
