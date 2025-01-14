package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Message;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.MessageMapper;
import cn.tedu.cppfoto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping
    public List<Message> message(HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            return messageService.select(user.getId());
        }
        return null;
    }

    @GetMapping("/deletebyid")
    public void deleteById(int id, HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            messageService.deleteById(id);
        }
    }
}
