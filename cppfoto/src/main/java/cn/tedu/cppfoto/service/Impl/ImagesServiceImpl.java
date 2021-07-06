package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Images;
import cn.tedu.cppfoto.mapper.ImagesMapper;
import cn.tedu.cppfoto.service.Imageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImagesServiceImpl implements Imageservice {
    @Autowired
    ImagesMapper imagesMapper;

    @Override
    @Transactional
    public int insert(Images images) {
        return imagesMapper.insert(images);
    }

    @Override
    public Images selectById(int id) {
        return imagesMapper.selectById(id);
    }

    @Override
    public Images selectByUserId(int id) {
        return imagesMapper.selectByUserId(id);
    }

    @Override
    public List<Images> selectByArticleId(int id) {
        return imagesMapper.selectByArticleId(id);
    }
}
