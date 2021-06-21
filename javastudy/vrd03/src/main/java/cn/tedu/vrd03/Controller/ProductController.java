package cn.tedu.vrd03.Controller;

import cn.tedu.vrd03.entity.Product;
import cn.tedu.vrd03.mapper.ProductMapper;
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
public class ProductController {
    @Autowired(required = false)
    ProductMapper pMapper;

    @RequestMapping("/send")
    public void send(Product product, MultipartFile file){
        System.out.println("product = " + product + ", file = " + file);
        String fileName=file.getOriginalFilename();
        //得到文件的后缀名
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        fileName= UUID.randomUUID()+suffix;
        System.out.println("唯一文件名:"+fileName);
        //得到日期相关的路径
        SimpleDateFormat f=new SimpleDateFormat("/yyyy/MM/dd/");
        //创建表示当前时间的日期的对象
        Date date=new Date();
        //得到日期路径
        String datePath=f.format(date);
        System.out.println("日期路径:"+datePath);
        String path="D:/down/upload"+datePath;
        //创建表示文件夹的文件对象
        File dirFile=new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();//表示连续创建多个文件夹
        }
        try {
            file.transferTo(new File(path+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //把图片的路径添加到product对象中，并且设置时间为当前系统时间
        product.setUrl(datePath+fileName);
        product.setCreated(date);
        pMapper.insert(product);
    }
    @RequestMapping("/selectproduct")
    public List<Product> selectproduct(){
        return pMapper.selectAll();
    }

    @RequestMapping("/likelist")
    public List<Product> likeList(){
       return pMapper.likeList();
    }

    @RequestMapping("/viewlist")
    public List<Product> viewList(){
        return pMapper.viewList();
    }

    @RequestMapping("/findbycid")
    public List<Product> findByCid(int id){
        return pMapper.findByCid(id);
    }

    @RequestMapping("/findbywd")
    public List<Product> findByWd(String wd){
        return pMapper.findByWd(wd);
    }
    @RequestMapping("/selectbyid")
    public Product findById(int id){
        return pMapper.findByid(id);
    }
    @RequestMapping("/likebyid")
    public int likeById(int id, HttpSession session){
        String likeId=(String) session.getAttribute("like"+id);
        if(likeId==null){
            pMapper.likeById(id);
            session.setAttribute("like"+id,"like"+id);
            return 1;//点赞了
        }
        return 2;//点过了
    }
}
