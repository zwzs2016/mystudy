package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Video;
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

    @Override
    public PageInfo<Video> select(int categoryId,int pageNum,int pageSize) {
        System.out.println("categoryId = " + categoryId + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<Video> videos = videoMapper.select(categoryId);
        return new PageInfo<>(videos);
    }
}
