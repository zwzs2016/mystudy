package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Images;

import java.util.List;

public interface Imageservice {
    int insert(Images images);

    Images selectById(int id);

    Images selectByUserId(int id);

    List<Images> selectByArticleId(int id);
}
