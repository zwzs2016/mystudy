package cn.tedu.vrd03.Controller;

import cn.tedu.vrd03.entity.Category;
import cn.tedu.vrd03.entity.User;
import cn.tedu.vrd03.mapper.CategoryMapper;
import cn.tedu.vrd03.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper uMapper;

    @RequestMapping("/login")
    public int login(User user, String rem, HttpServletResponse response){
        System.out.println("user = " + user + ", rem = " + rem + ", response = " + response);
        String password = uMapper.login(user.getUsername());
        if(password!=null){
            if(user.getPassword().equals(password)){
                if(rem!=null){
                    Cookie c1= new Cookie("username",user.getUsername());
                    Cookie c2= new Cookie("password",user.getPassword());
                    c1.setMaxAge(60*60*24*30);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                return 1;//登录成功
            }else {
                return 2;//密码错误
            }
        }
        return 3;//用户名不存在
    }

}
