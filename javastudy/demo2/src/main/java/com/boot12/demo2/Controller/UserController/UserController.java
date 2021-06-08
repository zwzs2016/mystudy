package com.boot12.demo2.Controller.UserController;

import com.boot12.demo2.entity.User;
import com.boot12.demo2.utils.DBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
public class UserController {
    @RequestMapping(path = "/register",produces = "text/html;charset=utf-8")
    public String reg(User user){
        System.out.println("user = " + user);
        try(Connection conn= DBUtils.getConn();) {
            String sql="insert into user values(null,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "注册成功";
    }
}
