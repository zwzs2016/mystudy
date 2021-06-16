package cn.tedu.boot61.controller;

import cn.tedu.boot61.entity.User;
import cn.tedu.boot61.entity.Weibo;
import cn.tedu.boot61.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class WeiboController {
    @Autowired(required = false)
    WeiboMapper mapper;

    @RequestMapping("/send")
    public int send(String content, MultipartFile pic, HttpSession session){
        //取出登录成功时，保存到seesion到的对象
        User user= (User) session.getAttribute("user");
        if(user==null){//没有登录
            return 2;
        }
        System.out.println("content = " + content + ", pic = " + pic);
        String fileName=pic.getOriginalFilename();
        System.out.println("文件名:"+fileName);
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        System.out.println("后缀名:"+suffix);
        fileName= UUID.randomUUID()+suffix;
        System.out.println("最终文件名:"+fileName);
        String dirPath="D:/down/upload/";
        File dirFile = new File(dirPath);
        if(!dirFile.exists()){
            dirFile.mkdirs();//如果文件不存在
        }
        try {
            pic.transferTo(new File(dirPath+fileName));
            System.out.println("保存完成!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //微博信息保存
        Weibo weibo=new Weibo();
        weibo.setContent(content);
        weibo.setUrl(fileName);//把上传后的文件名（相对路径封装到对象中0）
        weibo.setCreated(new Date());//当前系统时间,表示当前系统时间的对象
        weibo.setAuthor(user.getNick());
        weibo.setUserid(user.getId());

        //微博数据保存到微博表中
        mapper.insert(weibo);
        return 1;

    }

    @RequestMapping("/select")
    public List<Weibo> select(){
        return mapper.selectAll();
    }

    @RequestMapping("/myselect")
    public List<Weibo> myselect(HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user!=null){
            return mapper.selectByUserId(user.getId());
        }
        return null;
    }

    @RequestMapping("/deleteById")
    public void deleteById(int id){
        //先查id对应的图片路径
        String fileName=mapper.selectUrlById(id);
        String filepath="D:/down/upload/"+fileName;
        new File(filepath).delete();
        mapper.deleteById(id);
    }
}
