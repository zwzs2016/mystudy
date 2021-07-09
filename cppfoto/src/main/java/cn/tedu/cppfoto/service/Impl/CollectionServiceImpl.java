package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.CollectionVo;
import cn.tedu.cppfoto.entity.Collection;
import cn.tedu.cppfoto.exception.ServiceException;
import cn.tedu.cppfoto.mapper.CollectionMapper;
import cn.tedu.cppfoto.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void insert(Collection collection) {
        int num = cMapper.insert(collection);
        if(num!=0){
            throw new ServiceException("服务器忙!");
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        int num = cMapper.deleteById(id);
        if(num!=0){
            throw new ServiceException("服务器忙!");
        }
    }
}
