package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.Vo.CollectionVo;
import cn.tedu.cppfoto.entity.Collection;

import java.util.List;

public interface CollectionService {
    List<CollectionVo> select(int userId);

    Integer isCollection(Collection collection);

    void insert(Collection collection);

    void deleteById(int id);

}
