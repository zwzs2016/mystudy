package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Video;
import cn.tedu.cppfoto.mapper.VideoMapper;
import cn.tedu.cppfoto.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> select(int categoryId) {
        List<Video> videos = videoMapper.select(categoryId);
        return videos;
    }
}
