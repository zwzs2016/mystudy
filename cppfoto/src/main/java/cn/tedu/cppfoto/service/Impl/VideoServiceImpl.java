package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.VideoVo;
import cn.tedu.cppfoto.entity.Video;
import cn.tedu.cppfoto.mapper.OrderMapper;
import cn.tedu.cppfoto.mapper.VideoMapper;
import cn.tedu.cppfoto.service.VideoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo<Video> select(int categoryId,int pageNum,int pageSize) {
        System.out.println("categoryId = " + categoryId + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<Video> videos = videoMapper.select(categoryId,null);
        return new PageInfo<>(videos);
    }

    @Override
    public Video select(int id) {
        List<Video> videos = videoMapper.select(null, id);
        return videos.get(0);
    }

    @Override
    public List<VideoVo> selectVideoVos(Integer userId,String type) {
        return videoMapper.selectVideoVos(userId,type);
    }
}
