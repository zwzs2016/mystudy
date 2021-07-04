package cn.tedu.cppfoto.service;

import cn.tedu.cppfoto.entity.Order;
import org.apache.ibatis.annotations.Insert;

public interface OrderService {
    void order(int videoId,int userId,String type);

    void deleteById(int id);

    void updateCollectionById(int id,int isCollection);
}
