package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Integral;

import java.util.List;

public interface IntegralService {
    List<Integral> select(int id);

    int socreSum(int id);
}
