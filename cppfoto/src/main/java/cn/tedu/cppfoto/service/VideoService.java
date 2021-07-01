package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Video;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VideoService {
    PageInfo<Video> select(int categoryId,int pageNum,int pageSize);
}
