package cn.cppfoto.cppfoto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cppfoto.cppfoto.mapper.UserMapper;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper uMapper;

    @RequestMapping("/checkusername")
    public int checkUserName(String username){
        return  uMapper.checkUserName(username);
    }
}
