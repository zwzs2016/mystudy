package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Category;
import cn.tedu.cppfoto.mapper.CategoryMapper;
import cn.tedu.cppfoto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    CategoryMapper cMapper;

    private Map<String,List<Category>> categories=new ConcurrentHashMap<>();

    @Override
    public List<Category> select(String directory) {
        if(!categories.containsKey(directory)){
            synchronized (categories){
                if(!categories.containsKey(directory)){
                    categories.put(directory,cMapper.select(directory));
                }
            }

        }
        List<Category> categorieList = categories.get(directory);
        return categorieList;
    }
}
