package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.Vo.WordsVo;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.entity.Words;
import cn.tedu.cppfoto.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsController {
    @Autowired
    WordsService wordsService;

    @PostMapping("/add")
    public int insert(@RequestBody Words words, HttpSession session){
        System.out.println("words = " + words);
        User user=(User) session.getAttribute("user");
        if(session.getAttribute("user")==null){
            return 0;
        }
        words.setUserId(user.getId());
        System.out.println(words);
        wordsService.insert(words);
        return 1;
    }

    @GetMapping
    public List<WordsVo> select(HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            return wordsService.select(user.getId(),null);
        }
        return null;
    }

    @GetMapping("/selectbyarticleid")
    public List<WordsVo> selectByArticleId(int id, HttpSession session){
        if(session.getAttribute("user")!=null){
            return wordsService.select(null,id);
        }
        return null;
    }

    @GetMapping("/delwords")
    public void delWords(int id,HttpSession session){
        if(session.getAttribute("user")!=null){
            wordsService.deleteById(id);
        }
    }
}
