package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.CollectionVo;
import cn.tedu.cppfoto.entity.Collection;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.mapper.CollectionMapper;
import cn.tedu.cppfoto.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CollectionServiceImpl implements CollectionService {
    @Autowired(required = false)
    CollectionMapper cMapper;

    @Override
    public List<CollectionVo> select(int userId) {
        return cMapper.select(userId);
    }

    @Override
    public Integer isCollection(Collection collection) {
        return cMapper.isCollection(collection);
    }

    @Override
    public void insert(Collection collection) {
        cMapper.insert(collection);
    }

    @Override
    public void deleteById(int id) {
        cMapper.deleteById(id);
    }
}
