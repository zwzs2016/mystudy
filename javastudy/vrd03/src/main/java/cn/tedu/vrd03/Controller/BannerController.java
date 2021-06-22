package cn.tedu.vrd03.Controller;

import cn.tedu.vrd03.entity.Banner;
import cn.tedu.vrd03.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class BannerController {
    @Autowired(required = false)
    BannerMapper bMapper;
    @Value("${imageDirPath}")
    private String imageDirPath;

    @RequestMapping("/selectbanner")
    public List<Banner> selectbanner(){
        return bMapper.selectAll();
    }
    @RequestMapping("/deletebanner")
    public void deleteById(int id){
        String url=bMapper.findUrlById(id);
        //
        String path=imageDirPath+url;
        //
        new File(path).delete();
        bMapper.deleteById(id);
    }
    @RequestMapping("/uploadbanner")
    public void uploadBanner(MultipartFile file){
        //得到原始文件名
        //得到后缀名
        //得到唯一文件名
        //把文件保存到imagesDirPath路径下
        //把url设置给banner对象
        String fileName=file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        fileName= UUID.randomUUID()+suffix;
        Date date=new Date();
        SimpleDateFormat f=new SimpleDateFormat("/yyyy/MM/dd/");
        String datePath = f.format(date);
        String path=imageDirPath+datePath;
        //创建文件夹
        File dirFile=new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        try {
            file.transferTo(new File(path+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Banner banner=new Banner();
        banner.setUrl(datePath+fileName);
        bMapper.insert(banner);
    }
}
