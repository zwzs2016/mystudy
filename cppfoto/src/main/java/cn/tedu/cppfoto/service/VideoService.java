package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> select(int categoryId);
}
