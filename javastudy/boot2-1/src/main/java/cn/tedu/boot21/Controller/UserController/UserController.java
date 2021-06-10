package cn.tedu.boot21.Controller.UserController;

import cn.tedu.boot21.entity.User;
import cn.tedu.boot21.utils.DBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class UserController {
    @RequestMapping(path = "/login",produces = "text/html;charset=utf-8")
    public String login(User user){
        System.out.println("user = " + user);
        try(Connection conn= DBUtils.getConn()) {
            //通过用户名查询数据库密码 最后比较
            String sql="select password from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){//用户名存在
                //得到数据库里面的用户名
                String password=rs.getString(1);
                if(password.equals(user.getPassword())){
                    return "登录成功!";
                }
            }else {
                return "用户名不存在";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "密码错误!";
    }
}
