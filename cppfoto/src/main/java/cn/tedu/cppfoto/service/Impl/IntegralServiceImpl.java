package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Integral;
import cn.tedu.cppfoto.mapper.IntegralMapper;
import cn.tedu.cppfoto.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    IntegralMapper integralMapper;

    @Override
    public List<Integral> select(int id) {
        return integralMapper.select(id);
    }

    @Override
    public int socreSum(int id) {
        return integralMapper.socreSum(id);
    }
}
