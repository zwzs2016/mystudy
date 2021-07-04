package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping
    public int order(int videoId, String type,HttpSession session){
        //处理支付订单
        User user=(User) session.getAttribute("user");
        if(user!=null){
            orderService.order(videoId,user.getId(),type);
            return 1;
        }
        return 0;
    }

    @GetMapping("/deletebyid")
    public void deletebyid(int id,HttpSession session){
        if(session.getAttribute("user")!=null){
            orderService.deleteById(id);
        }
    }

    @GetMapping("/updatebyid")
    public void updateById(int id,int isCollection,HttpSession session){
        //收藏状态变更
        if(session.getAttribute("user")!=null){
            orderService.updateCollectionById(id,isCollection);
        }
    }

}
