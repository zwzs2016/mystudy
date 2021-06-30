package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> select(String directory);
}
