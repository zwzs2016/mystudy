package cn.tedu.boot41.Controller;

import cn.tedu.boot41.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/check")
    public String check(String username){
        System.out.println("username = " + username);
        String pw=mapper.login(username);
        if(pw!=null){
            return "用户名已存在!";
        }else {
            return "用户名可用";
        }
    }
    @RequestMapping("/info")
    public String info(){
        return "服务器接收到了请求!";
    }
    @RequestMapping("/login")
    public int login(String username,String password){
        System.out.println("username = " + username + ", password = " + password);
        String pw=mapper.login(username);
        if (pw!=null){
            //判断是否查询到数据
            if(pw.equals(password)){
                return 1;//登录成功!
            }else {
                return 2;//密码错误!
            }
        }else {
            return 3;//用户名不存在
        }
    }
}
