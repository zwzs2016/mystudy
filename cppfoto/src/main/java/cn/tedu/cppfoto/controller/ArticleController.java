package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.beans.Info;
import cn.tedu.cppfoto.entity.Article;
import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.mapper.UserMapper;
import cn.tedu.cppfoto.service.ArticleService;
import cn.tedu.cppfoto.utils.UploadFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    UploadFile uploadFile;

    @Autowired
    Info info;

    @RequestMapping
    public List<Article> Article(){
        return articleService.selctAll();
    }

    @RequestMapping("/add")
    public void add(Article article, MultipartFile file, MultipartFile[] files, HttpSession session){
        System.out.println("article = " + article + ", file = " + file + ", files = " + Arrays.deepToString(files) + ", session = " + session);
        User user=(User) session.getAttribute("user");
        article.setCreateDate(new Date());
        article.setUserId(user.getId());
        article.setImagesNum(files.length);
        articleService.insert(article);
        for (int i=0;i<files.length;i++){
            uploadFile.saveImg(files[i],article);
        }
    }
    @RequestMapping("/infos")
    public List<ArticleVo> infos(HttpSession session){
        User user=(User) session.getAttribute("user");
        System.out.println(user);
        if(user!=null){
            return articleService.selectById(user.getId());
        }
        return null;
    }
    @RequestMapping("/deletebyid")
    public void deleteById(int id){
        articleService.deleteById(id);
    }

    @RequestMapping("/info")
    public List<InfoVo> info(Info info){
        System.out.println("info = " + info);
        return articleService.selctInfoAll(info);
    }

    @RequestMapping("/detail")
    public Article selectById(int id){
        return articleService.select(id);
    }
    @RequestMapping("/heart")
    public int heart(int id,HttpSession session){
        if(session.getAttribute("heart")==null){
            session.setAttribute("heart","heart");
            articleService.heart(id);
            return 1;
        }
        return 0;
    }

}
