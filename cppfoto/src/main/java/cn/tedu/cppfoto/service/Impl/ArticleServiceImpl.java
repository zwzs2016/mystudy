package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.beans.Info;
import cn.tedu.cppfoto.entity.Article;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;


    @Override
    @Transactional
    public void insert(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public List<ArticleVo> selectById(int id) {
        return articleMapper.selectById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        articleMapper.deleteById(id);
    }

    @Override
    public List<InfoVo> selctInfoAll(Info info) {
        return articleMapper.selctInfoAll(info);
    }

    @Override
    public Article select(int id) {
        return articleMapper.select(id);
    }

    @Override
    @Transactional
    public void heart(int id) {
        articleMapper.heart(id);
    }

    @Override
    public List<Article> selctAll() {
        return articleMapper.selctAll();
    }
}
