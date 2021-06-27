package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.Vo.CollectionVo;
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
        System.out.println(words);
        wMapper.insert(words);
        return 1;
    }

    @GetMapping
    public List<WordsVo> select(HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            return wMapper.select(user.getId(),null);
        }
        return null;
    }

    @GetMapping("/selectbyarticleid")
    public List<WordsVo> selectByArticleId(int id, HttpSession session){
        if(session.getAttribute("user")!=null){
            return wMapper.select(null,id);
        }
        return null;
    }

    @GetMapping("/delwords")
    public void delWords(int id,HttpSession session){
        if(session.getAttribute("user")!=null){
            wMapper.deleteById(id);
        }
    }
}
