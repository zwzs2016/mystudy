package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.entity.Words;
import cn.tedu.cppfoto.mapper.WordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsController {
    @Autowired(required = false)
    WordsMapper wMapper;

    @PostMapping("/add")
    public int insert(@RequestBody Words words, HttpSession session){
        System.out.println("words = " + words);
        User user=(User) session.getAttribute("user");
        if(session.getAttribute("user")==null){
            return 0;
        }
        words.setUserId(user.getId());
        wMapper.insert(words);
        return 1;
    }

    @GetMapping
    public List<WordsVo> selectAll(HttpSession session){
        return wMapper.selectAll(((User)session.getAttribute("user")).getId());
    }
}
