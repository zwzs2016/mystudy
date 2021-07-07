package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.Vo.ArticleVo;
import cn.tedu.cppfoto.Vo.InfoVo;
import cn.tedu.cppfoto.beans.Info;
import cn.tedu.cppfoto.entity.Article;

import java.util.List;

public interface ArticleService {
    void insert(Article article);

    List<ArticleVo> selectById(int id);

    void deleteById(int id);

    List<InfoVo> selctInfoAll(Info info);

    Article select(int id);

    void heart(int id);

    List<Article> selctAll();

    void favorite(int id);
}
