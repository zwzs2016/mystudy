package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.entity.Article;
import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.mapper.UserMapper;
import cn.tedu.cppfoto.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired(required = false)
    ArticleMapper aMapper;

    @Autowired
    UploadFile uploadFile;

    @Autowired(required = false)
    UserMapper uMapper;

    @RequestMapping
    public List<Article> Article(){
        return aMapper.selctAll();
    }

    @RequestMapping("/add")
    public void add(Article article, MultipartFile file, HttpSession session){
        System.out.println("article = " + article + ", file = " + file + ", session = " + session);
        User user=(User) session.getAttribute("user");
        Integer imagesId = uploadFile.saveImg(file);
        article.setCreateDate(new Date());
        article.setUserId(uMapper.checkUserName(user.getUsername()).getId());
        article.setImgesNum(1);
        aMapper.insert(article);
    }
    @RequestMapping("/infos")
    public List<ArticleVo> infos(HttpSession session){
        User user=(User) session.getAttribute("user");
        System.out.println(user);
        if(user!=null){
            return aMapper.selectByUserName(user.getUsername());
        }
        return null;
    }
    @RequestMapping("/deletebyid")
    public void deleteById(int id){
        aMapper.deleteById(id);
    }

    @RequestMapping("/info")
    public List<InfoVo> info(){
       return aMapper.selctInfoAll();
    }
}
