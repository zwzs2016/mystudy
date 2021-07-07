package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Article;
import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ImagesMapper;
import cn.tedu.cppfoto.mapper.UserMapper;
import cn.tedu.cppfoto.service.Imageservice;
import cn.tedu.cppfoto.service.UserService;
import cn.tedu.cppfoto.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class ImagesController {
    @Autowired
    Imageservice imageservice;

    @Autowired
    UserService userService;

    @Autowired
    UploadFile uploadFile;

    //用户头像更换
    @RequestMapping("/portrait")
    public void portrait(MultipartFile file,HttpSession session){
        User user=(User)session.getAttribute("user");
        Integer imagesId = uploadFile.saveImg(file, new Article());
        user.setImagesId(imagesId);
        userService.update(user);
    }

    //用户头像查询
    @RequestMapping("/portrait/selectimg")
    public Images selectimg(HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user!=null){
            System.out.println(user);
            Images images=imageservice.selectById(user.getId());
            return images;
        }
        return null;
    }

    @RequestMapping("/images/selectbyuserid")
    public Images selectByUserId(int id){
        return imageservice.selectByUserId(id);
    }

    @RequestMapping("/selectbyarticleid")
    public List<Images> selectByArticleId(int id){
        return imageservice.selectByArticleId(id);
    }
}
