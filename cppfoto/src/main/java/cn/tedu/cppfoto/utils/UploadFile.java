package cn.tedu.cppfoto.utils;

import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.entity.User;
import cn.tedu.cppfoto.mapper.ImagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class UploadFile {
    @Autowired
    ImagesMapper iMapper;
    public Integer saveImg(MultipartFile file){
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
        return images.getId();
    }
}
