package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.UserMapper;
import cn.tedu.cppfoto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired(required = false)
    UserMapper uMapper;

    @PostMapping("/check")
    public int check(@RequestBody User user, HttpSession session){
        User u=(User) session.getAttribute("user");
        if(u!=null){
            user.setId(u.getId());
        }
        System.out.println("user = " + user);
        if(uMapper.check(user)!=null){
            return 1;//存在
        }
        return  0;//不存在
    }
    @RequestMapping("/reg")
    public int register(User user){
        System.out.println("user = " + user);
        if(uMapper.check(user)==null){
            uMapper.insert(user);
            userService.register(user);
            return 1;
        }
        return 2;
    }

    @RequestMapping("/login")
    public int login(User user, HttpSession session){
        User u=uMapper.check(user);
        if (u!=null){
            if(u.getPassword().equals(user.getPassword())){
                //密码一致
                session.setAttribute("user",u);
                //积分++
                userService.integral(u);
                //用户User存入redis
                userService.setUser(u);
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
            return userService.getUser(user);
            //return uMapper.check(user);
        }
        return new User();
    }

    @RequestMapping("/profileedit")
    public void profileedit(User user,HttpSession session){
        System.out.println("user = " + user);
        User u=(User)session.getAttribute("user");
        if(u!=null){
            user.setId(u.getId());
            userService.update(user);
        }
    }

    @RequestMapping("/selectuserbyid")
    public User selectUserById(int id){
        return uMapper.selectById(id);
    }

    @RequestMapping("/usersafe")
    public int userSafe(User user,HttpSession session){
        User u=(User)session.getAttribute("user");
        if(u!=null){
            user.setId(u.getId());
            System.out.println("user = " + user);
            uMapper.update(user);
            session.removeAttribute("user");
            return 1;
        }
        return 0;
    }
}
