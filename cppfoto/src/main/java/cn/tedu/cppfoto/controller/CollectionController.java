package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.Vo.CollectionVo;
import cn.tedu.cppfoto.entity.Collection;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.mapper.CollectionMapper;
import cn.tedu.cppfoto.service.ArticleService;
import cn.tedu.cppfoto.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired(required = false)
    CollectionService collectionService;

    @Autowired(required = false)
    ArticleService articleService;

    @GetMapping
    public List<CollectionVo> collection(HttpSession session){
        User user=(User) session.getAttribute("user");
        if (user!=null){
           return collectionService.select(user.getId());
        }
        return null;
    }

    @RequestMapping("/add")
    public int insert(int articleId,HttpSession session){
        System.out.println("articleId = " + articleId);
        User user=(User) session.getAttribute("user");
        if(user==null){
            return 2;
        }else {
            Collection collection=new Collection();
            collection.setArticleId(articleId);
            collection.setUserId(user.getId());
            if(collectionService.isCollection(collection)==null){
                collectionService.insert(collection);
                articleService.favorite(articleId);
                return 1;
            }
        }
        return 0;
    }

    @GetMapping("/deletebyid")
    public void deletebyid(int id,HttpSession session){
        if(session.getAttribute("user")!=null){
            collectionService.deleteById(id);
        }
    }
}
