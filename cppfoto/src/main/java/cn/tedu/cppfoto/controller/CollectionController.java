package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Collection;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired(required = false)
    CollectionMapper cMapper;
    @Autowired(required = false)
    ArticleMapper aMapper;

    @RequestMapping("/add")
    public int insert(int articleId,HttpSession session){
        System.out.println("articleId = " + articleId);
        User user=(User) session.getAttribute("user");
        if(user==null){
            return 3;
        }else {
            Collection collection=new Collection();
            collection.setArticleId(articleId);
            collection.setUserId(user.getId());
            if(cMapper.isCollection(collection)==null){
                cMapper.insert(collection);
                aMapper.favorite(articleId);
                return 1;
            }
        }
        return 0;
    }
}
