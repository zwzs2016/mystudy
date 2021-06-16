package cn.tedu.boot61.controller;

import cn.tedu.boot61.entity.User;
import cn.tedu.boot61.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(User user){
        System.out.println("user = " + user);
        User u=mapper.login(user.getUsername());
        if(u!=null){
            return 2;//2代表用户名已存在
        }
        mapper.insert(user);
        return 1;//代表注册成功!
    }

    @RequestMapping("/login")//session里面保存某个客户端相关数据
    public int login(User user, HttpSession session){
        User u=mapper.login(user.getUsername());
        if(u!=null){
            //查询到了
            if(user.getPassword().equals(u.getPassword())){
                //user
                session.setAttribute("user",u);
                return 1;
            }else {
                return 3;
            }
        }
        return 2;
    }

    @RequestMapping("/currentuser")
    public User currentUser(HttpSession session){
        //得到当前登录的对象
        return (User) session.getAttribute("user");
    }
    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }
}
