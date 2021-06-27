package cn.tedu.cppfoto.controller;

import cn.tedu.cppfoto.entity.Category;
import cn.tedu.cppfoto.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired(required = false)
    CategoryMapper cMapper;

    @RequestMapping
    public List<Category> category(String directory){
        System.out.println("directory = " + directory);
        return cMapper.select(directory);
    }
}
