package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper uMapper;

    @RequestMapping("/checkusername")
    public Integer checkUserName(String username){
        System.out.println("username = " + username);
        return  uMapper.checkUserName(username).getId();
    }

    @RequestMapping("/reg")
    public int register(User user){
        System.out.println("user = " + user);
        if(uMapper.checkUserName(user.getUsername())==null){
            uMapper.insert(user);
            return 1;
        }
        return 2;
    }

    @RequestMapping("/login")
    public int login(User user, HttpSession session){
        User u=uMapper.checkUserName(user.getUsername());
        if (u!=null){
            if(u.getPassword().equals(user.getPassword())){
                //密码一致
                session.setAttribute("user",user);
                return 1;
            }else {
                return 2;//密码错误
            }
        }
        return 3;
    }

    @RequestMapping("/islogin")
    public User islogin(HttpSession session){
        return (User) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }

    @RequestMapping("/profile")
    public User profile(HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user!=null){
            return uMapper.checkUserName(user.getUsername());
        }
        return new User();
    }

    @RequestMapping("/profileedit")
    public void profileedit(User user){
        System.out.println("user = " + user);
        uMapper.update(user);
    }
}
