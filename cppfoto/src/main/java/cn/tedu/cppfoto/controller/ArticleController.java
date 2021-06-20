package cn.tedu.cppfoto.controller;

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

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired(required = false)
    ArticleMapper aMapper;

    @Autowired
    UploadFile uploadFile;

    @Autowired
    UserMapper uMapper;

    @RequestMapping("/add")
    public void add(Article article, MultipartFile file, HttpSession session){
        System.out.println("article = " + article + ", file = " + file + ", session = " + session);
        User user=(User) session.getAttribute("user");
        Integer imagesId = uploadFile.saveImg(file);
        article.setCreateDate(new Date());
        article.setUserId(uMapper.checkUserName(user.getUsername()).getId());
        article.setImgesId(imagesId);
        aMapper.insert(article);
    }
}