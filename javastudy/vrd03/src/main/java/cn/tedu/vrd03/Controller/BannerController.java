package cn.tedu.vrd03.Controller;

import cn.tedu.vrd03.entity.Banner;
import cn.tedu.vrd03.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {
    @Autowired(required = false)
    BannerMapper bMapper;

    @RequestMapping("/selectbanner")
    public List<Banner> selectbanner(){
        return bMapper.selectAll();
    }
}
