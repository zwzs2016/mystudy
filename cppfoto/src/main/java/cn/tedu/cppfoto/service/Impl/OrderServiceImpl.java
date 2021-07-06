package cn.tedu.cppfoto.service.Impl;

import cn.tedu.cppfoto.entity.Order;
import cn.tedu.cppfoto.mapper.OrderMapper;
import cn.tedu.cppfoto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    @Transactional
    public void order(int videoId,int userId,String type) {
        Order order=new Order();
        order.setPaystatus(type.equals("collection")?0:1)
                .setIsCollection(type.equals("collection")?1:0)
                .setUserId(userId)
                .setVideoId(videoId)
                .setCreateDate(new Date());
        Order order_a = orderMapper.selectByUserIdAndVideoId(userId, videoId);
        if (order_a==null){
            orderMapper.insert(order);
        }else {
            if(order_a.getIsCollection()==0){
                orderMapper.updateCollectionById(order_a.getId(),1);
            }
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        orderMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCollectionById(int id,int isCollection) {
        orderMapper.updateCollectionById(id,isCollection);
    }


}
;