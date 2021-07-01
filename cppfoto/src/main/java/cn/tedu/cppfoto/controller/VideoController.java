package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Video;
import cn.tedu.cppfoto.service.VideoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired(required = false)
    VideoService videoService;

    @GetMapping
    public PageInfo<Video> select(int categoryId,Integer pageNum){
        System.out.println("categoryId = " + categoryId);
        return videoService.select(categoryId,pageNum==null?1:pageNum,4);
    }
}
