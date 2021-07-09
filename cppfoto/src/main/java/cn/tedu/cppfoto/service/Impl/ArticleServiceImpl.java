package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.beans.Info;
import cn.tedu.cppfoto.entity.Article;
import cn.tedu.cppfoto.exception.ServiceException;
import cn.tedu.cppfoto.mapper.ArticleMapper;
import cn.tedu.cppfoto.mapper.WordsMapper;
import cn.tedu.cppfoto.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    WordsMapper wordsMapper;

    @Override
    @Transactional
    public void insert(Article article) {
        int num = articleMapper.insert(article);
        if(num==0){
            throw new ServiceException("服务器忙！");
        }
    }

    @Override
    public List<ArticleVo> selectById(int id) {
        return articleMapper.selectById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        int m = articleMapper.deleteById(id);
        int n = wordsMapper.deleteByArticleId(id);
        if(m!=1 || n!=1){
            throw new ServiceException("服务器忙！");
        }
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
        int num = articleMapper.heart(id);
        if(num==0){
            throw new ServiceException("服务器忙!");
        }
    }

    @Override
    public List<Article> selctAll() {
        return articleMapper.selctAll();
    }

    @Override
    @Transactional
    public void favorite(int id) {
        int num = articleMapper.favorite(id);
        if(num==0){
            throw new ServiceException("服务器忙!");
        }
    }
}
