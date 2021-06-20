package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ImagesMapper;
import cn.tedu.cppfoto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class ImagesController {
    @Autowired(required = false)
    ImagesMapper iMapper;
    @Autowired
    UserMapper uMapper;

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
        System.out.println("username"+user.getUsername());
        if(user!=null){
            Images images=iMapper.selectById(user.getUsername());
            return images;
        }
        return null;
    }

}
