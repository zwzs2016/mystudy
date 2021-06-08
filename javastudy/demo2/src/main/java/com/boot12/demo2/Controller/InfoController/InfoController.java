package com.boot12.demo2.Controller.InfoController;

import com.boot12.demo2.entity.User;
import com.boot12.demo2.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Controller
public class InfoController {
    @RequestMapping(path = "/info",produces = "text/html;charser=utf-8")
    @ResponseBody
//    public String info(String username,String password,String age,String[] hobby){
//        System.out.println("username = " + username + ", password = " + password);
//        for (String s : hobby) {
//            System.out.println(s);
//        }
//        return "收到请求了!";
//    }
    public String info(User user){
        System.out.println("user = " + user);

        return "收到请求了!";
    }
}
