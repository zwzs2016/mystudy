package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Integral;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.IntegralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/integral")
public class IntegralController {
    @Autowired
    IntegralMapper inteMapper;
    @GetMapping
    public List<Integral> integral(HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            return inteMapper.select(user.getId());
        }
        return null;
    }
    @GetMapping("/scoresum")
    public int scoreSum(HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
           return inteMapper.socreSum(user.getId());
        }
        return 0;
    }
}
