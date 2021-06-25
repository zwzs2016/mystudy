package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ImagesMapper;
import cn.tedu.cppfoto.mapper.UserMapper;
import cn.tedu.cppfoto.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired(required = false)
    ImagesMapper iMapper;
    @Autowired(required = false)
    UserMapper uMapper;
    @Autowired
    UploadFile uploadFile;

    @RequestMapping("/portrait")
    public void portrait(MultipartFile file){
        String fileName=file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        fileName= UUID.randomUUID()+suffix;
        SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd/");
        Date date=new Date();
        String datePath=f.format(date);
        String path="D:/upload/"+datePath;
        File dirFile=new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        try {
            file.transferTo(new File(path+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Images images = new Images();
        images.setImgUrl("/"+datePath+fileName);
        iMapper.insert(images);
        User user=new User();
        user.setImagesId(images.getId());
        uMapper.update(user);
    }

    @RequestMapping("/portrait/selectimg")
    public Images selectimg(HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user!=null){
            System.out.println(user);
            Images images=iMapper.selectById(user.getId());
            return images;
        }
        return null;
    }

    @RequestMapping("/images/selectbyuserid")
    public Images selectByUserId(int id){
        return iMapper.selectByUserId(id);
    }

    @RequestMapping("/selectbyarticleid")
    public List<Images> selectByArticleId(int id){
        return iMapper.selectByArticleId(id);
    }
}
